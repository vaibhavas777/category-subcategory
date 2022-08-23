package com.abacus.categorysubcategory.repository;

import com.abacus.categorysubcategory.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory,Integer> {

    /*@Query("INSERT INTO sub_category s (subcategory_id, subcategory_name, ) VALUES (:subCatId,:subCatName)" +
            "WHERE s.category_id_fk = :categoryId")
    public SubCategory addSubCategory(Integer subCatId, String subCatName,Integer categoryId);*/
}
