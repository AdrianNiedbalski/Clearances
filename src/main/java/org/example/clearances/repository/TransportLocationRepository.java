package org.example.clearances.repository;

import org.example.clearances.model.TransportLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportLocationRepository extends JpaRepository<TransportLocation, Long> {
}
