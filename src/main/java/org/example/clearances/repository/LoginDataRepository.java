package org.example.clearances.repository;

import org.example.clearances.model.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDataRepository extends JpaRepository<LoginData, Long> {

    Optional<LoginData> findByLogin(String login);
}
