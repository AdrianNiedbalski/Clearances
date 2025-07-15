package org.example.clearances.repository;

import org.example.clearances.model.CustomsOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomsOfficeRepository extends JpaRepository<CustomsOffice, Integer> {
}
