package com.example.FlashSale.Service;

import com.example.FlashSale.RequestDTO.OrderRequestDTO;
import com.example.FlashSale.ResponseDTO.OrderResponseDTO;

public interface FlashSaleService {
    OrderResponseDTO response(OrderRequestDTO request);
}
