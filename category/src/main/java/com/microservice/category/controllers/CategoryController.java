//package com.microservice.category.controllers;
//
//import com.microservice.category.dto.CategoryDto;
//import com.microservice.category.facades.CategoryFacade;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//public class CategoryController {
//
//    @Autowired
//    private CategoryFacade facade;
//
//    @PostMapping("/categories")
//    public CategoryDto addCategory(@RequestBody CategoryDto category) {
//        return facade.saveCategory(category);
//    }
//
//    @GetMapping("/categories")
//    public List<CategoryDto> findAllCategories() {
//        return facade.getAllCategories();
//    }
//
//    @GetMapping("/categories/{id}")
//    public CategoryDto findAllCategories(@PathVariable Integer id) {
//        return facade.getCategoryById(id);
//    }
//
//    @PutMapping("/categories/{id}")
//    public CategoryDto updateCategory(@PathVariable Integer id, @RequestBody CategoryDto dto) {
//        return facade.updateCategory(id, dto);
//    }
//
////    @DeleteMapping("/categories/{id}")
////    @Transactional
////    public void deleteCategory(@PathVariable Integer id) {
////        facade.deleteCartegory(id);
////    }
//}
