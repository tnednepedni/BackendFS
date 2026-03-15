package com.example.FlashSale.Service.impl;

import com.example.FlashSale.DTO.FlashSaleProductDTO;
import com.example.FlashSale.Entity.FlashSaleProduct;
import com.example.FlashSale.Entity.Order;
import com.example.FlashSale.Repository.FlashSaleProductRepo;
import com.example.FlashSale.Repository.OrderRepo;
import com.example.FlashSale.RequestDTO.OrderRequestDTO;
import com.example.FlashSale.ResponseDTO.OrderResponseDTO;
import com.example.FlashSale.Service.FlashSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlashSaleServiceImpl implements FlashSaleService {

    private final FlashSaleProductRepo flashSaleProductRepo;
    private final OrderRepo orderRepo;

    @Override
    public OrderResponseDTO response(OrderRequestDTO request) {

        FlashSaleProduct flashSaleProduct =
                flashSaleProductRepo.findByProduct_Id(request.getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not in flash sale"));

        Integer purchased = orderRepo.getUserPurchase(
                request.getUserId(),
                flashSaleProduct.getId()
        );

        if (purchased + request.getQuantity() > flashSaleProduct.getMaxPerUser()) {
            return new OrderResponseDTO(false, "Exceed max purchase per user");
        }

        int updated = flashSaleProductRepo.decreaseStock(
                request.getProductId(),
                request.getQuantity()
        );

        if (updated == 0) {
            return new OrderResponseDTO(false, "Out of stock");
        }

        Order order = new Order();
        order.setQuantity(request.getQuantity());
        order.setStatus(true);

        orderRepo.save(order);

        return new OrderResponseDTO(true, "Order success");
    }
}
