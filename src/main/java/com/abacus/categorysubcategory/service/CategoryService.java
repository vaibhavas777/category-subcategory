package com.abacus.categorysubcategory.service;

import com.abacus.categorysubcategory.dto.CategoryDto;
import com.abacus.categorysubcategory.dto.SubCategoryDto;

import java.util.List;

public interface CategoryService {

    //CATEGORY CRUDS
    public CategoryDto saveCategory(CategoryDto categoryDto);
    public CategoryDto updateCateory(CategoryDto categoryDto, Integer categoryId);
    public void deleteCategory(Integer categoryId);
    public CategoryDto getCategoryById(Integer categoryId);
    public List<CategoryDto> getAllCategories();



}
