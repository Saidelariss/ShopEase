package com.ecom.shopease.mappers;

import com.ecom.shopease.dtos.ProductResponse;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category", target = "categoryName", qualifiedByName = "categoryName")
    ProductResponse toProductResponse(Product product);

    @Named("categoryName")
    default String mapCategoryName(Category category) {
        return category != null ? category.getName() : null;
    }
}
