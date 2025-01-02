package com.ecom.shopease.repositories;

import com.ecom.shopease.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findAll(Pageable pageable);

}
