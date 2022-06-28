package com.microservice.borrow.iservices;

import com.microservice.borrow.entities.Borrow;

import java.util.List;

public interface IBorrowService {

    public Borrow saveBorrow(Borrow user);
    public List<Borrow> getAllBorrow();
    public Borrow getBorrowByID(Integer id);

    public List<Borrow> getBorrowByStatus(boolean status);

    List<Borrow> getByTransactionId(Integer id);
//    List<Borrow> getByUserId(Integer id);

    public Borrow updateBorrow(Integer id, Borrow borrow);

}
