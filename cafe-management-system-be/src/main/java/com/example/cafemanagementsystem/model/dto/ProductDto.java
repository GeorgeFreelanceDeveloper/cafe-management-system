package com.example.cafemanagementsystem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Integer id;

    private String name;

    private String description;

    private Integer price;

    private String status;

    private Integer categoryId;

    private String categoryName;

}
