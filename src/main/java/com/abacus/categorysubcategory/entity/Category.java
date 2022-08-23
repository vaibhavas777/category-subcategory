package com.abacus.categorysubcategory.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotNull(message = "title must be filled")
    private String categoryTitle;
    @Column(name = "description")
    private String categoryDescription;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER ,targetEntity = SubCategory.class)
   @JoinColumn(name = "category_id_fk" , referencedColumnName = "categoryId")
   private List<SubCategory> subCategoryList;

}
