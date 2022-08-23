package com.abacus.categorysubcategory.controller;

import com.abacus.categorysubcategory.dto.CategoryDto;
import com.abacus.categorysubcategory.dto.SubCategoryDto;
import com.abacus.categorysubcategory.service.SubCategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
@Log4j2
public class SubCatController {

    @Autowired
    SubCategoryService subCategoryService;

    @PostMapping("/{categoryID}")
    public ResponseEntity<SubCategoryDto> saveSubCategory(@RequestBody SubCategoryDto subcat){
        log.info("inside saveSubCategory :"+ subcat);
        return new ResponseEntity<>(subCategoryService.saveSubCategory(subcat), HttpStatus.CREATED);
    }

    @PutMapping("/{catID}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(@RequestBody SubCategoryDto subcat , @PathVariable Integer catID){
        log.info("inside updateSubCategory id is :"+catID +" obj :"+ subcat);
        return new ResponseEntity<>(subCategoryService.updateSubCateory(subcat,catID), HttpStatus.CREATED);
    }

    @GetMapping("/{subCatId}")
    @RestResource(exported = false)
    public ResponseEntity<SubCategoryDto> getSubCategoryById(@PathVariable Integer subCatId){
          log.info("inside getSubCategoryById "+subCatId);
        return new ResponseEntity<>(subCategoryService.getSubCategoryById(subCatId), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RestResource(exported = false)
    public ResponseEntity<List<SubCategoryDto>> getAllCategories(){
        List<SubCategoryDto> list =  subCategoryService.getAllSubCategories();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{subCatId}")
    @RestResource(exported = false)
    public ResponseEntity<String> deleteCategoryById(@PathVariable Integer subCatId){

        subCategoryService.deleteSubCategory(subCatId);
        return new ResponseEntity<>("Deleted Succefully", HttpStatus.ACCEPTED);
    }
}
