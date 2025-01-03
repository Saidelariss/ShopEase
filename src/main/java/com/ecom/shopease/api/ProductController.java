package com.ecom.shopease.api;

import com.ecom.shopease.entities.Product;
import com.ecom.shopease.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    Page<Product> getProducts(Pageable pageable){
        return productService.getProducts(pageable);
    }
}
