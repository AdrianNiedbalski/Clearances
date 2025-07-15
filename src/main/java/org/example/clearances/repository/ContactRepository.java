package org.example.clearances.repository;

import org.example.clearances.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> { }
