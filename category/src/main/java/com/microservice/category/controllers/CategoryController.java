package com.microservice.category.controllers;

import com.microservice.category.dto.CategoryDto;
import com.microservice.category.facades.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController{
    @Autowired
    private CategoryFacade facade;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(facade.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(Integer id) {
        return new ResponseEntity<>(facade.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> saveCategory(CategoryDto body) {
        facade.saveCategory(body);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Void> updateCategory(Integer id, CategoryDto body) {
        facade.updateCategory(id, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(Integer id) {
        facade.deleteCartegory(id);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
