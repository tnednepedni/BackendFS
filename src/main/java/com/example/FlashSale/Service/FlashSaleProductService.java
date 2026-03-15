package com.example.FlashSale.Service;

import com.example.FlashSale.DTO.FlashSaleDTO;
import com.example.FlashSale.DTO.FlashSaleProductDTO;

import java.util.List;

public interface FlashSaleProductService {
    FlashSaleProductDTO findByProductId(Long product_id);

    List<FlashSaleProductDTO> getAllProducts();

    void decreaseStock(Long flashSaleProduct_id, Integer quantity);
}
