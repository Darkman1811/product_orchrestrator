package com.guestu.springbootcamel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
    private String description;
    private String smallImageUrl;
    private String bigImageUrl;
    @JsonManagedReference
    private List<Category> childrens;
   @JsonBackReference
    private Category parent;


}
