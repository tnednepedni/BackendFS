package com.example.FlashSale.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "flash_sales")
@Getter
@Setter
public class FlashSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime createdAt;

}
