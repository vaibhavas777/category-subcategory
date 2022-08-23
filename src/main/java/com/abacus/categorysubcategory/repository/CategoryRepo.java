package com.abacus.categorysubcategory.repository;

import com.abacus.categorysubcategory.entity.Category;
import com.abacus.categorysubcategory.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
