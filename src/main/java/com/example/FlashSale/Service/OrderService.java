package com.example.FlashSale.Service;

import com.example.FlashSale.DTO.OrderDTO;
import com.example.FlashSale.RequestDTO.AddRequestOrderDTO;

public interface OrderService {
    OrderDTO createNewOrder(AddRequestOrderDTO addRequestOrderDTO);

    Integer countUserOrders(Long userId, Long flashSaleProductId);
}
