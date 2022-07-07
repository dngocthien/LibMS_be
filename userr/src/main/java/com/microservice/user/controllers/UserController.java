package com.microservice.user.controllers;

import com.microservice.user.dto.UserDto;
import com.microservice.user.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserFacade facade;

    @PostMapping("/users")
    public UserDto saveUserById(@RequestBody UserDto dto) {
        return facade.saveUser(dto);
    }

    @GetMapping("/users")
    public List<UserDto> findAllUsers() {
        return facade.getAllUser();
    }

    @GetMapping("/users/id/{id}")
    public List<UserDto> findUserById(@PathVariable Integer id) {
        List<UserDto> list = new ArrayList<>();
        list.add(facade.getUserById(id));
        return list;
    }

    @GetMapping("/users/{text}")
    public List<UserDto> findUserByName(@PathVariable String text) {
        return facade.getUserByName(text);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUserById(@PathVariable Integer id, @RequestBody UserDto dto) {
        return facade.updateUser(id, dto);
    }

}
