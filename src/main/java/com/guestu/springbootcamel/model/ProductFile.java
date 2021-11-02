package com.guestu.springbootcamel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFile {
    private Long id;
    private String url;
    private String filetype;
}
