package com.abacus.categorysubcategory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SubCategory {

    @Id
    @Column(name = "subcategory_id")
    private Integer subCatId;

    @Column(name = "subcategory_name")
    @NotNull(message = "name must be provided")
    private String subCatName;

   /* @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Category category;*/

}
