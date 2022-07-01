package com.microservice.admin.repo;

import com.microservice.admin.entities.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepo extends JpaRepository<LoginData, Integer> {
    Optional<LoginData> findByEmail(String email);
    Boolean existsByEmail(String email);
}
