package com.abacus.categorysubcategory.controller;

import com.abacus.categorysubcategory.dto.CategoryDto;
import com.abacus.categorysubcategory.dto.SubCategoryDto;
import com.abacus.categorysubcategory.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Log4j2
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    @RestResource(exported = false)
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
        log.info("Inside saveCategory :"+ categoryDto);
        return new ResponseEntity<CategoryDto>(categoryService.saveCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping
    @RestResource(exported = false)
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        log.info("Inside getAllCategories ");
       List<CategoryDto> list =  categoryService.getAllCategories();
      return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    @RestResource(exported = false)
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
     log.info("inside getCategoryById id is :"+categoryId);
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategoryById(@PathVariable Integer categoryId, @RequestBody CategoryDto categoryDto){
        log.info("Inside update category , Id is :"+ categoryId);
        return new ResponseEntity<>(categoryService.updateCateory(categoryDto, categoryId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{categoryId}")
    @RestResource(exported = false)
    public ResponseEntity<String> deleteCategoryById(@PathVariable Integer categoryId){
        log.info("inside deleteCategoryById id is :"+categoryId);
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Deleted Succefully", HttpStatus.ACCEPTED);
    }

}
