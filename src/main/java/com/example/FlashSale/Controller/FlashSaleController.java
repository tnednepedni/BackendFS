package com.example.FlashSale.Controller;

import com.example.FlashSale.RequestDTO.OrderRequestDTO;
import com.example.FlashSale.ResponseDTO.OrderResponseDTO;
import com.example.FlashSale.Service.FlashSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flash-sale")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class FlashSaleController {
    private final FlashSaleService flashSaleService;
    @PostMapping("/order")
    public ResponseEntity<OrderResponseDTO> orderFlashSale(
            @RequestBody OrderRequestDTO request
    ) {
        OrderResponseDTO response =
                flashSaleService.response(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
