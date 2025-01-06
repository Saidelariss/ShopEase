package com.ecom.shopease.apis;

import com.ecom.shopease.dtos.AddProductRequest;
import com.ecom.shopease.dtos.ProductResponse;
import com.ecom.shopease.entities.Product;
import com.ecom.shopease.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody AddProductRequest product) {
        productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/products")
    public Page<ProductResponse> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @PatchMapping("/products/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer productId, @RequestParam Integer categoryId) {

        productService.updateCategory(productId,categoryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
