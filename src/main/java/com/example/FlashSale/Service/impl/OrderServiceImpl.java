package com.example.FlashSale.Service.impl;

import com.example.FlashSale.DTO.OrderDTO;
import com.example.FlashSale.Entity.Order;
import com.example.FlashSale.Repository.OrderRepo;
import com.example.FlashSale.RequestDTO.AddRequestOrderDTO;
import com.example.FlashSale.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;

    @Override
    public OrderDTO createNewOrder(AddRequestOrderDTO addRequestOrderDTO) {
        Order newOrder = modelMapper.map(addRequestOrderDTO, Order.class);
        Order order = orderRepo.save(newOrder);
        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public Integer countUserOrders(Long userId, Long flashSaleProductId) {
        return orderRepo.getUserPurchase(userId, flashSaleProductId);
    }
}
