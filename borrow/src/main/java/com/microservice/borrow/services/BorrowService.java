package com.microservice.borrow.services;

import com.microservice.borrow.entities.Borrow;
import com.microservice.borrow.iservices.IBorrowService;
import com.microservice.borrow.repo.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService implements IBorrowService {

    @Autowired
    private BorrowRepo repository;

    @Override
    public Borrow saveBorrow(Borrow user) {
        return repository.save(user);
    }

    @Override
    public List<Borrow> getAllBorrow() {
        return (List<Borrow>) repository.findAll();
    }

    @Override
    public Borrow getBorrowByID(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Borrow> getByTransactionId(Integer id) {
        return repository.findByTransactionId(id);
    }

    @Override
    public List<Borrow> getBorrowByStatus(boolean status) {
        return repository.getByStatus(status);
    }

    @Override
    public Borrow updateBorrow(Integer id, Borrow borrow) {
        Optional<Borrow> query = repository.findById(id);
        if(query.isPresent()){
            Borrow existing = query.get();
            existing.setReturnDate(borrow.getReturnDate());
            existing.setStatus(borrow.isStatus());
            existing.setBookId(borrow.getBookId());
            existing.setTransactionId(borrow.getTransactionId());
            return repository.save(existing);
        }
        return null;
    }
}
