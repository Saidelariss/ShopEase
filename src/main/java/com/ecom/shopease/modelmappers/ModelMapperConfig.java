package com.ecom.shopease.modelmappers;

import com.ecom.shopease.dtos.ProductResponse;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.entities.Product;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {


//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        TypeMap<Product, ProductResponse> typeMap = modelMapper.createTypeMap(Product.class, ProductResponse.class);
//        typeMap.addMappings(mapper -> {
//            mapper.using(ctx -> {
//                Category category = (Category) ctx.getSource();
//                return category.getName() + " with id: " + category.getId();
//            }).map(Product::getCategory, ProductResponse::setCategoryName);
//        });
//        return modelMapper;
//    }

    //The same thing as the previous bean
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Product, ProductResponse> typeMap = modelMapper.createTypeMap(Product.class, ProductResponse.class);
        typeMap.addMappings(mapper -> {
            mapper.using(convertCategoryToString()).map(Product::getCategory, ProductResponse::setCategoryName);
        });
        return modelMapper;
    }


    public Converter<Category, String> convertCategoryToString() {
        return context -> context.getSource() != null ? context.getSource().getName() + " with id: " + context.getSource().getId() : "";
    }

}
