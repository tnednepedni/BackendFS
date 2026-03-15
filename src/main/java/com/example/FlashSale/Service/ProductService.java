package com.example.FlashSale.Service;

import com.example.FlashSale.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO findById(Long id);
}
