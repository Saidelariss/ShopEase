package com.ecom.shopease.services;

import com.ecom.shopease.entities.Product;
import com.ecom.shopease.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public Page<Product> getProducts(Pageable pageable){
        return repository.findAll(pageable);
    }
}
