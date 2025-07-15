package org.example.clearances.repository;

import org.example.clearances.model.Customs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomsRepository extends JpaRepository<Customs, Integer> {

    @Query("""
        SELECT emp.login, COUNT(c)
        FROM Customs c
        JOIN c.employee emp
        WHERE FUNCTION('MONTH', c.createdAt) = :month
          AND FUNCTION('YEAR',  c.createdAt) = :year
        GROUP BY emp.login
    """)
    List<Object[]> countClearancesByEmployeeForMonth(@Param("month") int month,
                                                     @Param("year")  int year);

    @Query("""
        SELECT FUNCTION('TO_CHAR', c.createdAt, 'YYYY-MM'), COUNT(c)
        FROM Customs c
        GROUP BY FUNCTION('TO_CHAR', c.createdAt, 'YYYY-MM')
        ORDER BY 1
    """)
    List<Object[]> countClearancesPerMonth();

    @Query("SELECT DISTINCT c.customsType FROM Customs c")
    List<String> findDistinctCustomsTypes();

    @Query("SELECT DISTINCT c.exporter.name FROM Customs c")
    List<String> findDistinctExporters();

    @Query("SELECT DISTINCT c.importer.name FROM Customs c")
    List<String> findDistinctImporters();

    @Query("SELECT DISTINCT c.employee.login FROM Customs c")
    List<String> findDistinctEmployees();

    @Query("SELECT DISTINCT c.status FROM Customs c")
    List<String> findDistinctStatuses();

    List<Customs> findByStatus(String status);
}
