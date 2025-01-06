package com.ecom.shopease.apis;

import com.ecom.shopease.dtos.AddCategoryRequest;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Page<Category> getCategories(Pageable pageable){
        return categoryService.findAll(pageable);
    }

}
