package com.microservice.transaction.controllers;

import com.microservice.transaction.dto.ByTime;
import com.microservice.transaction.dto.TransactionBorrows;
import com.microservice.transaction.dto.TransactionDto;
import com.microservice.transaction.facades.TransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionFacade facade;

    @PostMapping("/transactions")
    public TransactionDto addTransactionBorrows(@RequestBody TransactionBorrows transactionBorrows) {
        System.out.println(transactionBorrows.getTransactionDto().toString());
        return facade.saveTransactionBorrows(transactionBorrows.getTransactionDto(), transactionBorrows.getBorrowDtoList());
    }

//    @PostMapping("/transactions")
//    public TransactionDto addTransaction(@RequestBody TransactionDto dto) {
//        return facade.saveTransaction(dto);
//    }

    @GetMapping("/transactions")
    public List<TransactionDto> findAllTransaction() {
        return facade.getAllTransaction();
    }

    @GetMapping("/transactions/overdue")
    public List<TransactionDto> findOverdueTransaction() {
        return facade.getTransactionByOverdue();
    }

    @GetMapping("/transactions/{id}")
    public TransactionDto findTransactionById(@PathVariable Integer id) {
        return facade.getTransactionById(id);
    }

    @GetMapping("/transactions/user/{id}")
    public List<TransactionDto> findTransactionByUserId(@PathVariable Integer id) {
        return facade.getTransactionByUserId(id);
    }

    @PostMapping("/transactions/time")
    public List<TransactionDto> findTransactionByTime(@RequestBody ByTime byTime) {
        return facade.findTransactionByTime(byTime.getFromDate(), byTime.getToDate());
    }

    @PutMapping("/transactions/{id}")
    public TransactionDto updateBook(@PathVariable Integer id, @RequestBody TransactionDto dto){
        return facade.updateTransaction(id, dto);
    }


}
