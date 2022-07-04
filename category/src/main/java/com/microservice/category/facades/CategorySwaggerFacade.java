package com.microservice.category.facades;

import com.microservice.category.entities.Category;
import com.microservice.category.iservices.ICategoryService;
import com.sun.istack.NotNull;
import io.tej.SwaggerCodgen.model.CategorySwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategorySwaggerFacade {
    @Autowired
    private ICategoryService service;

    public void saveCategory(@NotNull CategorySwagger dto) {
        Category model = service.saveCategory(dto2Model(dto));
    }

    public List<CategorySwagger> getAllCategories() {
        List<Category> modelList = service.getAllCategories();
        return addDtoList(modelList);
    }

    public CategorySwagger getCategoryById(@NotNull Integer id) {
        Category model = service.getCategoryByID(id);
        return model2Dto(model);
    }

    public void updateCategory(@NotNull Integer id, @NotNull CategorySwagger dto) {
        Category model = service.updateCategory(id, dto2Model(dto));
    }

    public void deleteCartegory(Integer id) {
        service.deleteCategory(id);
    }

    private Category dto2Model(CategorySwagger dto){
        Category model = new Category();
        model.setName(dto.getName());
        return model;
    }

    private CategorySwagger model2Dto(Category model){
        CategorySwagger dto = new CategorySwagger();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }

    private List<Category> addModelList(List<CategorySwagger> dtoList){
        List<Category> modelList = new ArrayList<>();
        for(CategorySwagger m: dtoList){
            modelList.add(dto2Model(m));
        }
        return modelList;
    }

    private List<CategorySwagger> addDtoList(List<Category> modelList){
        List<CategorySwagger> dtoList = new ArrayList<>();
        for(Category m: modelList){
            dtoList.add(model2Dto(m));
        }
        return dtoList;
    }
}
