package com.ecom.shopease.repositories;

import com.ecom.shopease.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
