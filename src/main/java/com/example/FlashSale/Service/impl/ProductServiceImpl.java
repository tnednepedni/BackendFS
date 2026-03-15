package com.example.FlashSale.Service.impl;

import com.example.FlashSale.DTO.ProductDTO;
import com.example.FlashSale.DTO.UserDTO;
import com.example.FlashSale.Entity.Product;
import com.example.FlashSale.Entity.User;
import com.example.FlashSale.Repository.ProductRepo;
import com.example.FlashSale.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Khong tim thay Product: " + id));
        return modelMapper.map(product, ProductDTO.class);
    }
}
