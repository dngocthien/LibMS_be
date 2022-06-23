package com.microservice.book.repo;

import com.microservice.book.entities.Own;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnRepo extends JpaRepository<Own, Integer> {

//    @Query("SELECT o FROM Own o WHERE o.bookId = ?1")
    List<Own> findByBookId(Integer id);

    void deleteByBookId(Integer id);
}
