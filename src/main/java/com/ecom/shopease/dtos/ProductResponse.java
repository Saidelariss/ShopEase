package com.ecom.shopease.dtos;

import lombok.Data;

@Data
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String categoryName;
    private String image_url;
}
