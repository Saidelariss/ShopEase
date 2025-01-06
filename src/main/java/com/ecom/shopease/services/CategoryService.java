package com.ecom.shopease.services;

import com.ecom.shopease.dtos.AddCategoryRequest;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.repositories.CategoryRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
public class CategoryService {
    private final CategoryRepository repository;

    public void addCategory(AddCategoryRequest category) {
        Category cat = new Category();
        cat.setCreatedAt(LocalDateTime.now());
        cat.setName(category.getCategoryName());
        repository.save(cat);
    }

    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
