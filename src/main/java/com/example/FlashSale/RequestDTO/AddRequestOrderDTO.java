package com.example.FlashSale.RequestDTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddRequestOrderDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    @Max(2)
    private Integer quantity;
}
