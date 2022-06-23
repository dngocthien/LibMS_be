package com.microservice.transaction.repo;

import com.microservice.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.userId = ?1  AND t.finished = false")
    List<Transaction> findByUserId(Integer id);

    @Query("SELECT t FROM Transaction t WHERE t.dueDate < CURRENT_DATE() AND t.finished = false")
    List<Transaction> findByOverdue();
}
