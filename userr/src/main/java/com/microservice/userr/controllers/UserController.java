package com.microservice.userr.controllers;

import com.microservice.userr.dto.UserDto;
import com.microservice.userr.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserFacade facade;

    @PostMapping("/users")
    public ResponseEntity<UserDto> saveUserById(@RequestBody UserDto dto, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<>(facade.saveUser(dto), HttpStatus.OK);
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

    @GetMapping("/users/active")
    public List<UserDto> findActiveUsers() {
        return facade.getActiveUsers();
    }

    @PutMapping("/users/{id}")
    public UserDto updateUserById(@PathVariable Integer id, @RequestBody UserDto dto) {
        return facade.updateUser(id, dto);
    }

}
