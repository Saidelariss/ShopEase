package com.ecom.shopease.services;

import com.ecom.shopease.dtos.AddProductRequest;
import com.ecom.shopease.dtos.ProductResponse;
import com.ecom.shopease.entities.Category;
import com.ecom.shopease.entities.Product;
import com.ecom.shopease.mappers.ProductMapper;
import com.ecom.shopease.repositories.CategoryRepository;
import com.ecom.shopease.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductMapper mapper;
    @Autowired
    private CategoryRepository categoryRepository;

    private ModelMapper modelMapper = new ModelMapper();//risque

    public Page<ProductResponse> getProducts(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        return products.map(product -> {
            return mapper.toProductResponse(product);
        });

    }

    public void createProduct(AddProductRequest product) {
        Product pro = Product.builder()
                .name(product.getProductName())
                .description(product.getProductDescription())
                .price(product.getProductPrice()).build();
        repository.save(pro);
    }

    public void updateCategory(Integer productId, Integer categoryId) {
        Product product = repository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCategory(category);
        repository.save(product);

    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
