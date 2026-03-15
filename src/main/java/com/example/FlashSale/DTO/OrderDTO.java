package com.example.FlashSale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long userId;

    private Long productId;

    private Integer quantity;

}
