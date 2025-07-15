package org.example.clearances.repository;

import org.example.clearances.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> { }
