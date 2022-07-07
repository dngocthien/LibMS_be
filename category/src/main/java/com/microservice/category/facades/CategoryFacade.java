package com.microservice.category.facades;

import com.microservice.category.dto.CategoryDto;
import com.microservice.category.entities.Category;
import com.microservice.category.iservices.ICategoryService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryFacade {
    @Autowired
    private ICategoryService service;

    public void saveCategory(@NotNull CategoryDto dto) {
        service.saveCategory(dto2Model(dto));
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> modelList = service.getAllCategories();
        return addDtoList(modelList);
    }

    public CategoryDto getCategoryById(@NotNull Integer id) {
        Category model = service.getCategoryByID(id);
        return model2Dto(model);
    }

    public void updateCategory(@NotNull Integer id, @NotNull CategoryDto dto) {
        Category model = service.updateCategory(id, dto2Model(dto));
    }

    public void deleteCartegory(Integer id) {
        service.deleteCategory(id);
    }

    private Category dto2Model(CategoryDto dto){
        Category model = new Category();
        model.setName(dto.getName());
        return model;
    }

    private CategoryDto model2Dto(Category model){
        CategoryDto dto = new CategoryDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }

    private List<Category> addModelList(List<CategoryDto> dtoList){
        List<Category> modelList = new ArrayList<>();
        for(CategoryDto m: dtoList){
            modelList.add(dto2Model(m));
        }
        return modelList;
    }

    private List<CategoryDto> addDtoList(List<Category> modelList){
        List<CategoryDto> dtoList = new ArrayList<>();
        for(Category m: modelList){
            dtoList.add(model2Dto(m));
        }
        return dtoList;
    }
}
