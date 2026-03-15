package com.example.FlashSale.Service.impl;

import com.example.FlashSale.DTO.FlashSaleProductDTO;
import com.example.FlashSale.Entity.FlashSaleProduct;
import com.example.FlashSale.Repository.FlashSaleProductRepo;
import com.example.FlashSale.Service.FlashSaleProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashSaleProductServiceImpl implements FlashSaleProductService {
    private final FlashSaleProductRepo flashSaleProductRepo;
    private final ModelMapper modelMapper;


    @Override
    public FlashSaleProductDTO findByProductId(Long product_id) {
        FlashSaleProduct flashSaleProduct = flashSaleProductRepo.findById(product_id).orElseThrow(()
                -> new RuntimeException("San pham khong duoc giam gia: " + product_id));
        return modelMapper.map(flashSaleProduct, FlashSaleProductDTO.class);
    }

    @Override
    public List<FlashSaleProductDTO> getAllProducts() {
        return flashSaleProductRepo.findAllFlashSaleProducts();
    }

    @Override
    public void decreaseStock(Long flashSaleProduct_id, Integer quantity) {
        FlashSaleProduct fsp = flashSaleProductRepo.findById(flashSaleProduct_id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay san pham: " + flashSaleProduct_id));

        if (fsp.getStock() < quantity) {
            throw new RuntimeException("San pham da ban het");
        }

        fsp.setStock(fsp.getStock() - quantity);
        flashSaleProductRepo.save(fsp);
    }
}
