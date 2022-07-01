package com.microservice.category.iservices;


import com.microservice.category.entities.Category;

import java.util.List;

public interface ICategoryService {

    public Category saveCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategoryByID(Integer id);
    public List<Category> getCategoryByName(String name);
    Category updateCategory(Integer id, Category dto2Model);
    public void deleteCategory(Integer id);

}
