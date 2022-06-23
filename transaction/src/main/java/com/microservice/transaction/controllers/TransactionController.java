package com.microservice.transaction.controllers;

import com.microservice.transaction.dto.TransactionDto;
import com.microservice.transaction.facades.TransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionFacade facade;

    @PostMapping("/transactions")
    public TransactionDto addUser(@RequestBody TransactionDto dto) {
        return facade.saveTransaction(dto);
    }

    @GetMapping("/transactions")
    public List<TransactionDto> findAllTransaction() {
        return facade.getAllTransaction();
    }

    @GetMapping("/transactions/{id}")
    public TransactionDto findTransactionById(@PathVariable Integer id) {
        return facade.getTransactionById(id);
    }

    @GetMapping("/transactions/user/{id}")
    public List<TransactionDto> findTransactionByName(@PathVariable Integer id) {
        return facade.getTransactionByUserId(id);
    }

}
