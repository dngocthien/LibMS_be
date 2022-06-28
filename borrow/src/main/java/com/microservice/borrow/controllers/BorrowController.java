package com.microservice.borrow.controllers;

import com.microservice.borrow.dto.BorrowDto;
import com.microservice.borrow.facades.BorrowFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/borrows/transaction/{id}")
    public List<BorrowDto> getBorrowsByTransactionId(@PathVariable Integer id){
        return facade.getBorrowByTransactionId(id);
    }

//    @GetMapping("/borrows/user/{id}")
//    public List<BorrowDto> getBorrowsByUserId(@PathVariable Integer id){
//        return facade.getBorrowsByUserId(id);
//    }

    @PutMapping("/borrows/{id}")
    public ResponseEntity<BorrowDto> updateBorrow(@PathVariable Integer id, @RequestBody BorrowDto dto, HttpServletResponse response){
//        return facade.updateBorrow(id, dto);
        facade.updateBorrow(id, dto);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.updateBorrow(id, dto), HttpStatus.OK);
    }
}
