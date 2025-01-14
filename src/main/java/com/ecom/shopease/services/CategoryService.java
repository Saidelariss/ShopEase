package com.ecom.shopease.services;

import com.ecom.shopease.dtos.AddCategoryRequest;
import com.ecom.shopease.dtos.CategoryResponse;
import com.ecom.shopease.dtos.CategoryResponseWithProducts;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.mappers.CategoryMapper;
import com.ecom.shopease.repositories.CategoryRepository;
import lombok.Data;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final ModelMapper modelMapper;

    public void addCategory(AddCategoryRequest category) {
        Category cat = new Category();
        cat.setCreatedAt(LocalDateTime.now());
        cat.setName(category.getCategoryName());
        repository.save(cat);
    }

    public Page<CategoryResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toCategoryResponse);
    }

    public Page<CategoryResponseWithProducts> findWithProducts(Pageable pageable) {
        return repository.findAll(pageable).map(e -> modelMapper.map(e, CategoryResponseWithProducts.class));
    }

    public List<CategoryResponseWithProducts> findAllCategoriesWithProducts() {
        Object map = modelMapper.map(repository.findAll(), new TypeToken<List<CategoryResponseWithProducts>>() {
        }.getType());
        return (List<CategoryResponseWithProducts>) map;
    }


}
