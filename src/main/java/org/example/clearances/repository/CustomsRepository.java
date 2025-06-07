package org.example.clearances.repository;

import org.example.clearances.model.Customs;
import org.example.clearances.model.CustomsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomsRepository extends JpaRepository<Customs, Long> {

    @Query("SELECT CONCAT(a.person.firstName, ' ', a.person.lastName), COUNT(c) " +
            "FROM Customs c JOIN c.agent a " +
            "WHERE FUNCTION('MONTH', c.createdAt) = :month AND FUNCTION('YEAR', c.createdAt) = :year " +
            "GROUP BY a.person.firstName, a.person.lastName")
    List<Object[]> countClearancesByAgentForMonth(@Param("month") int month, @Param("year") int year);

    @Query("SELECT FUNCTION('TO_CHAR', c.createdAt, 'YYYY-MM'), COUNT(c) " +
            "FROM Customs c GROUP BY FUNCTION('TO_CHAR', c.createdAt, 'YYYY-MM') ORDER BY 1")
    List<Object[]> countClearancesPerMonth();

    @Query("SELECT DISTINCT c.customsType.customsType FROM Customs c")
    List<String> findDistinctTypes();

    @Query("SELECT DISTINCT c.exporter.name FROM Customs c")
    List<String> findDistinctExporters();

    @Query("SELECT DISTINCT c.importer.name FROM Customs c")
    List<String> findDistinctImporters();

    @Query("SELECT DISTINCT CONCAT(c.agent.person.firstName, ' ', c.agent.person.lastName) FROM Customs c")
    List<String> findDistinctAgents();

    @Query("SELECT DISTINCT c.status FROM Customs c")
    List<String> findDistinctStatuses();

    List<Customs> findByStatus(CustomsStatus status);
}
