package com.abacus.categorysubcategory.service;
import com.abacus.categorysubcategory.dto.CategoryDto;
import com.abacus.categorysubcategory.dto.SubCategoryDto;
import com.abacus.categorysubcategory.entity.Category;
import com.abacus.categorysubcategory.entity.SubCategory;
import com.abacus.categorysubcategory.repository.CategoryRepo;
import com.abacus.categorysubcategory.repository.SubCategoryRepo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@Log4j2
public class CategoryServiceImpl implements  CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired(required=true)
    private ModelMapper modelMapper;


    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
     Category cat =  this.modelMapper.map(categoryDto, Category.class);
     log.info("inside service");
     return this.modelMapper.map(this.categoryRepo.save(cat), CategoryDto.class);
    }

    @Override
    public CategoryDto updateCateory(CategoryDto categoryDto, Integer categoryId) {
        log.info("inside service");
      Category cat = categoryRepo.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Record with id "+categoryId+" not found"));
      cat.setCategoryTitle(categoryDto.getCategoryTitle());
      cat.setCategoryDescription(categoryDto.getCategoryDescription());

      return modelMapper.map(this.categoryRepo.save(cat), CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        log.info("inside service");
        Category cat = categoryRepo.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Record with id "+categoryId+" not found"));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        log.info("inside service");
        Category cat = categoryRepo.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Record with id "+categoryId+" not found"));
        return modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        log.info("inside service");
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> catDtos =  categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }


}
