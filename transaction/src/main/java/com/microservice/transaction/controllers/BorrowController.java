package com.microservice.transaction.controllers;

import com.microservice.transaction.dto.BorrowDto;
import com.microservice.transaction.facades.BorrowFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class BorrowController {

    @Autowired
    BorrowFacade facade;

    @PostMapping("/borrows")
    public BorrowDto addBorrow(@RequestBody BorrowDto dto){
        return facade.saveBorrow(dto);
    }

    @GetMapping("/borrows")
    public List<BorrowDto> getAllBorrows(){
        return facade.getAllBorrows();
    }

    @GetMapping("/borrows/{status}")
    public List<BorrowDto> getBorrowsByStatus(@PathVariable boolean status){
        return facade.getBorrowByStatus(status);
    }

    @GetMapping("/borrows/transaction/{id}")
    public List<BorrowDto> getBorrowsByTransactionId(@PathVariable Integer id){
        return facade.getBorrowByTransactionId(id);
    }

    @GetMapping("/borrows/expired")
    public List<BorrowDto> getExpiredBorrows(){
        return facade.getBorrowByOverDue();
    }

    @PutMapping("/borrows/{id}")
    public BorrowDto updateBorrow(@PathVariable Integer id, @RequestBody BorrowDto dto){
        return facade.updateBorrow(id, dto);
    }
}
