package com.microservice.category.services;

import com.microservice.category.entities.Category;
import com.microservice.category.iservices.ICategoryService;
import com.microservice.category.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepo repository;

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Category getCategoryByID(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void deleteCategory(Integer id){
        repository.deleteById(id);
    }

}
