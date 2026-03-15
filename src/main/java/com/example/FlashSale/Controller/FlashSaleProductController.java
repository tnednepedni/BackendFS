package com.example.FlashSale.Controller;

import com.example.FlashSale.DTO.FlashSaleProductDTO;
import com.example.FlashSale.Service.FlashSaleProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flash-sale")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FlashSaleProductController {
    private final FlashSaleProductService flashSaleProductService;
    @GetMapping("/products")
    public ResponseEntity<List<FlashSaleProductDTO>> getAllProducts(){
        return ResponseEntity.ok(flashSaleProductService.getAllProducts());
    }
}
