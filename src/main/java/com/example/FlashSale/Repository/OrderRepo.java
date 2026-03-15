package com.example.FlashSale.Repository;

import com.example.FlashSale.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("""
        SELECT COALESCE(SUM(o.quantity),0)
        FROM Order o
        WHERE o.user.id = :userId
        AND o.flashSaleProduct.id = :flashSaleProductId
    """)
    Integer getUserPurchase(@Param("userId") Long userId,
                            @Param("flashSaleProductId") Long flashSaleProductId);
}
