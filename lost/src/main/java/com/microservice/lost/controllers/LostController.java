package com.microservice.lost.controllers;

import com.microservice.lost.dto.LostDto;
import com.microservice.lost.facades.LostFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LostController {

    @Autowired
    private LostFacade facade;

    @PostMapping("/losts")
    public LostDto addUser(@RequestBody LostDto dto) {
        return facade.saveLost(dto);
    }

    @GetMapping("/losts")
    public List<LostDto> findAllLosts() {
        return facade.getAllLost();
    }

    @GetMapping("/losts/{id}")
    public LostDto findLostById(@PathVariable Integer id) {
        return facade.getLostById(id);
    }

    @GetMapping("/losts/book/{id}")
    public List<LostDto> findLostByName(@PathVariable Integer id) {
        return facade.getLostByBookId(id);
    }

    @GetMapping("/losts/user/{id}")
    public List<LostDto> findTransactionByName(@PathVariable Integer id) {
        return facade.getLostByUserId(id);
    }

}
