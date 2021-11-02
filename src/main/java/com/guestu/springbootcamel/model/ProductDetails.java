package com.guestu.springbootcamel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {

    private Long id;
    private String label;
    private String value;
}
