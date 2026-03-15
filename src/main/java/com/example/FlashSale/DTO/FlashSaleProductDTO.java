package com.example.FlashSale.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashSaleProductDTO {
    private Long productId;

    private String name;

    private Double salePrice;

    private Integer stock;

    private Integer maxPerUser;
}
