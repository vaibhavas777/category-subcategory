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
import org.springframework.data.domain.Example;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SubCategoryServiceImpl implements SubCategoryService{

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public SubCategoryDto saveSubCategory(SubCategoryDto subCategoryDto) {
        log.info("inside service");
      SubCategory subCat =  modelMapper.map(subCategoryDto, SubCategory.class);
      return modelMapper.map(subCategoryRepo.save(subCat), SubCategoryDto.class);
    }

    @Override
    public SubCategoryDto updateSubCateory(SubCategoryDto subCategoryDto, Integer subCatId) {
        log.info("inside service");
        SubCategory subcat = subCategoryRepo.findById(subCatId).orElseThrow(() -> new ResourceNotFoundException("Record with id "+subCatId+" not found"));
        subcat.setSubCatName(subCategoryDto.getSubCatName());
        subcat.setSubCatId(subCategoryDto.getSubCatId());
        return modelMapper.map(subCategoryRepo.save(subcat), SubCategoryDto.class);
    }

    @Override
    public void deleteSubCategory(Integer subCatId) {
        log.info("inside service");
       SubCategory subcat = subCategoryRepo.findById(subCatId).
               orElseThrow(() -> new ResourceNotFoundException("Record with id "+subCatId+" not found"));
       subCategoryRepo.delete(subcat);

       List<SubCategory> list =subCategoryRepo.findAll();
       if(list.isEmpty()){
           categoryRepo.deleteAll();
       }
    }

    @Override
    public SubCategoryDto getSubCategoryById(Integer subCatId) {
        log.info("inside service");
       SubCategory subcat = subCategoryRepo.findById(subCatId).
                orElseThrow(() -> new ResourceNotFoundException("Record with id "+subCatId+" not found"));
        return modelMapper.map(subcat, SubCategoryDto.class);
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        log.info("inside service");
        List<SubCategory> subcats = subCategoryRepo.findAll();
        return  subcats.stream().map(subcat-> modelMapper.map(subcat, SubCategoryDto.class)).collect(Collectors.toList());
    }
}
