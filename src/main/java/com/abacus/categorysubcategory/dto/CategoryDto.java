package com.abacus.categorysubcategory.dto;

import com.abacus.categorysubcategory.entity.SubCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {

    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
    private List<SubCategory> subCategoryList;

}
