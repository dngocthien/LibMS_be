package com.microservice.user.repo;

import com.microservice.user.entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<Userr, Integer> {

    @Query("select u from Userr u where lower(u.name) like lower(concat('%', ?1,'%'))")
    List<Userr> findByNameContaining(String text);

}
