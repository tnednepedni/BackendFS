package com.example.FlashSale.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flash_sale_product_id", referencedColumnName = "id")
    private FlashSaleProduct flashSaleProduct;

    private Integer quantity;

    private Boolean status;

    private LocalDateTime createdAt;
}
