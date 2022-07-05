package com.microservice.borrow.controllers;

import com.microservice.borrow.dto.BorrowDto;
import com.microservice.borrow.dto.ByTime;
import com.microservice.borrow.facades.BorrowFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BorrowController {

    @Autowired
    BorrowFacade facade;

    @PostMapping("/borrows/many")
    public ResponseEntity<List<BorrowDto>> addBorrows(@RequestBody List<BorrowDto> dto, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.saveBorrows(dto), HttpStatus.OK);
    }

    @PostMapping("/borrows")
    public ResponseEntity<BorrowDto> addBorrow(@RequestBody BorrowDto dto, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.saveBorrow(dto), HttpStatus.OK);
    }

    @GetMapping("/borrows")
    public ResponseEntity<List<BorrowDto>> getAllBorrows(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.getAllBorrows(), HttpStatus.OK);
    }

    @GetMapping("/borrows/transaction/{id}")
    public ResponseEntity<List<BorrowDto>> getBorrowsByTransactionId(@PathVariable Integer id, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.getBorrowByTransactionId(id), HttpStatus.OK);
    }

    @GetMapping("/borrows/user/{id}")
    public List<BorrowDto> getBorrowsByUserId(@PathVariable("id") Integer id){
        return facade.getBorrowsByUserId(id);
    }

    @PostMapping("/borrows/time")
    public Map<Integer, Integer> getBorrowIdsByTime(@RequestBody ByTime byTime) {
        return facade.getBorrowIdsByTime(byTime);
    }

    @PutMapping("/borrows/{id}")
    public ResponseEntity<BorrowDto> updateBorrow(@PathVariable Integer id, @RequestBody BorrowDto dto, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.updateBorrow(id, dto), HttpStatus.OK);
    }
}
