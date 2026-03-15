package com.example.FlashSale.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "flash_sale_products")
@Getter
@Setter
public class FlashSaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flash_sale_id", referencedColumnName = "id")
    private FlashSale flashSale;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Double salePrice;

    private Integer stock;

    private Integer maxPerUser;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
