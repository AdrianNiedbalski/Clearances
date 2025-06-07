package org.example.clearances.repository;

import org.example.clearances.model.TransportType;
import org.example.clearances.model.TransportTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransportTypeRepository extends JpaRepository<TransportType, Long> {

    Optional<TransportType> findByTransportType(String transportType);
}