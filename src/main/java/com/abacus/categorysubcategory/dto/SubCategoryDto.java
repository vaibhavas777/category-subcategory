package com.abacus.categorysubcategory.dto;

import com.abacus.categorysubcategory.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubCategoryDto {

    private Integer subCatId;
    private String subCatName;


}
