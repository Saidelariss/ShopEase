package com.ecom.shopease.entities;

import com.ecom.shopease.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    private double totalAmount;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    @OneToOne(mappedBy = "order")
    private Payment payment;
}
