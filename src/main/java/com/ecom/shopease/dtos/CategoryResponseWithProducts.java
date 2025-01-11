package com.ecom.shopease.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseWithProducts {
    private Integer id;
    private String name;
    private List<ProductResponse> products;
}
