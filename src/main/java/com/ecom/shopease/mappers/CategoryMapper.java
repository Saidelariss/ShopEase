package com.ecom.shopease.mappers;

import com.ecom.shopease.dtos.CategoryResponse;
import com.ecom.shopease.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(Category category);
}
