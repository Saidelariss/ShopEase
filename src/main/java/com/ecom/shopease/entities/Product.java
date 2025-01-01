package com.ecom.shopease.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @ManyToOne
    private Category category;
    private String image_url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "product")
    List<CartItem> cartItems;
    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItems;

}
