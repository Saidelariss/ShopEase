package com.ecom.shopease.dtos;

import lombok.Data;

@Data
public class AddProductRequest {
    private String productName;
    private String productDescription;
    private double productPrice;
    private Integer categoryId;
}
