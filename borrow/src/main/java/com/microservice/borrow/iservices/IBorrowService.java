package com.microservice.borrow.iservices;

import com.microservice.borrow.entities.Borrow;

import java.util.List;

public interface IBorrowService {

    public Borrow saveBorrow(Borrow borrow);

    public List<Borrow> saveBorrows(List<Borrow> borrows);

    public List<Borrow> getAllBorrow();

    public Borrow getBorrowByID(Integer id);

    public List<Borrow> getBorrowByStatus(boolean status);

    List<Borrow> getByTransactionId(Integer id);

    List<Integer> getBookIdsByTransactionId(Integer id);

    public Borrow updateBorrow(Integer id, Borrow borrow);

}
