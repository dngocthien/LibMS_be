package com.microservice.borrow.repo;

import com.microservice.borrow.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Integer> {
    List<Borrow> getByStatus(boolean status);

    @Query("SELECT b FROM Borrow b WHERE b.returnDate < CURRENT_DATE() AND b.status = false")
    List<Borrow> getByOverDue();

    List<Borrow> findByTransactionId(Integer id);
}
