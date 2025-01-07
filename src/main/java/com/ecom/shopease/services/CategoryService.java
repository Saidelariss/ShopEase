package com.ecom.shopease.services;

import com.ecom.shopease.dtos.AddCategoryRequest;
import com.ecom.shopease.dtos.CategoryResponse;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.mappers.CategoryMapper;
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
    private final CategoryMapper mapper;

    public void addCategory(AddCategoryRequest category) {
        Category cat = new Category();
        cat.setCreatedAt(LocalDateTime.now());
        cat.setName(category.getCategoryName());
        repository.save(cat);
    }

    public Page<CategoryResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toCategoryResponse);
    }
}
