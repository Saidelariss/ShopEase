package com.ecom.shopease.apis;

import com.ecom.shopease.dtos.AddCategoryRequest;
import com.ecom.shopease.dtos.CategoryResponse;
import com.ecom.shopease.dtos.CategoryResponseWithProducts;
import com.ecom.shopease.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Void> createCategory(@RequestBody AddCategoryRequest category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<CategoryResponse> getCategories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("details")
    public Page<CategoryResponseWithProducts> getCategoriesWithProducts(Pageable pageable) {
        return categoryService.findWithProducts(pageable);
    }

    @GetMapping("all")
    public List<CategoryResponseWithProducts> getAllCategoriesWithProducts(){
        return categoryService.findAllCategoriesWithProducts();
    }

}
