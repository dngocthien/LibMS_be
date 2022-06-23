package com.microservice.book.repo;

import com.microservice.book.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query("select u from Book u where lower(u.title) like lower(concat('%', ?1,'%'))")
    List<Book> findByTitleLike(String text);

    @Query("SELECT b from Book b where b.quantity < 1")
    List<Book> findByNone();

//    List<Book> findByTitleContaining(String text);

}
