package com.guestu.springbootcamel.ressource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    Long id;
    String firstName;
    String lastName;
    int age;
}
