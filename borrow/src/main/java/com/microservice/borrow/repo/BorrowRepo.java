package com.microservice.borrow.repo;

import com.microservice.borrow.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Integer> {
    List<Borrow> getByStatus(boolean status);

    @Query("SELECT b FROM Borrow b WHERE b.transactionId = ?1 ORDER BY b.id ASC")
    List<Borrow> findByTransactionIdSorted(Integer id);

//    @Query("SELECT DISTINCT b FROM Borrow b, transaction tr INNER JOIN b ON b.transactionId = tr.id WHERE tr.userId = 5" )
////            "FROM borrow b, transaction tr\n" +
////            "INNER JOIN borrow ON borrow.transactionId = tr.id\n" +
////            "WHERE tr.userId = 5")
//    List<Borrow> findByUserId(Integer id);

}
