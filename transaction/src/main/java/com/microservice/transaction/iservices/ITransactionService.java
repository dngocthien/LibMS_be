package com.microservice.transaction.iservices;

import com.microservice.transaction.entities.Transaction;

import java.util.Date;
import java.util.List;

public interface ITransactionService {

    public Transaction saveTransaction(Transaction user);
    public List<Transaction> getAllTransaction();
    public Transaction getTransactionByID(Integer id);
    public List<Transaction> getByUserId(Integer id);
    public List<Transaction> getByOverdue();
    List<Transaction> getTransactionByTime(String start, String end);
    Transaction updateTransaction(Integer id, Transaction dto);

}
