package com.ecom.shopease.entities;

import com.ecom.shopease.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private CompteUser user;
    private double totalAmount;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    @OneToOne(mappedBy = "order")
    private Payment payment;
}
