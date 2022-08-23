package com.abacus.categorysubcategory.service;

import com.abacus.categorysubcategory.dto.CategoryDto;
import com.abacus.categorysubcategory.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {

    public SubCategoryDto saveSubCategory(SubCategoryDto subCategoryDto);
    public SubCategoryDto updateSubCateory(SubCategoryDto subCategoryDto, Integer subCatId);
    public void deleteSubCategory(Integer subCatId);
    public SubCategoryDto getSubCategoryById(Integer subCatId);
    public List<SubCategoryDto> getAllSubCategories();
}
