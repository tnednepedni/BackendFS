package com.example.FlashSale.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private Long userId;

    private Long productId;

    private Integer quantity;

}
