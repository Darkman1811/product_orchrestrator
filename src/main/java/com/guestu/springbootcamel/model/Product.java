package com.guestu.springbootcamel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Date creationDate ;
    private String description;
    private Category category;
    @JsonIgnore
    private List<ProductTag> productTags;
    @JsonIgnore
    private List<ProductDetails> productDetails;
    @JsonIgnore
    private List<ProductFile> productFiles;
}
