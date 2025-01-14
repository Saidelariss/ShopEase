package com.ecom.shopease.repositories;

import com.ecom.shopease.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
