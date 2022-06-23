package com.microservice.category.controllers;

import com.microservice.category.dto.CategoryDto;
import com.microservice.category.facades.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryFacade facade;

    @PostMapping("/categories")
    public CategoryDto addCart(@RequestBody CategoryDto category) {
        return facade.saveCategory(category);
    }

    @GetMapping("/categories")
    public List<CategoryDto> findAllCategories() {
        return facade.getAllCategories();
    }

    @DeleteMapping("/categories/{id}")
    @Transactional
    public void deleteCategory(@PathVariable Integer id) {
        facade.deleteCart(id);
    }
}
