package com.microservice.lost.repo;

import com.microservice.lost.entities.Lost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostRepo extends JpaRepository<Lost, Integer> {

    List<Lost> findByUserId(Integer id);
    List<Lost> findByBookId(Integer id);
}
