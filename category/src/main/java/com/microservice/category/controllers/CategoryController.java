package com.microservice.category.controllers;

import com.microservice.category.facades.CategoryFacade;
import io.tej.SwaggerCodgen.api.CategoriesApi;
import io.tej.SwaggerCodgen.model.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoriesApi {
    @Autowired
    private CategoryFacade facade;

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(facade.getAllCategories(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Integer id) {
        return new ResponseEntity<>(facade.getCategoryById(id), HttpStatus.OK);
    }

    public ResponseEntity<Void> getAllCategory(CategoryDto body) {
        facade.saveCategory(body);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    public ResponseEntity<Void> updateCategory(Integer id, CategoryDto body) {
        facade.updateCategory(id, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Integer id) {
        facade.deleteCartegory(id);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
