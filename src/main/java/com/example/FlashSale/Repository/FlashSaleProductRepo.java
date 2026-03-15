package com.example.FlashSale.Repository;

import com.example.FlashSale.DTO.FlashSaleProductDTO;
import com.example.FlashSale.Entity.FlashSaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface FlashSaleProductRepo extends JpaRepository<FlashSaleProduct, Long> {
    Optional<FlashSaleProduct> findByProduct_Id(Long productId);
    @Modifying
    @Transactional
    @Query("""
        UPDATE FlashSaleProduct f
        SET f.stock = f.stock - :quantity
        WHERE f.product.id = :productId
        AND f.stock >= :quantity
    """)
    int decreaseStock(@Param("productId") Long productId,
                      @Param("quantity") Integer quantity);
    @Query("""
    SELECT new com.example.FlashSale.DTO.FlashSaleProductDTO(
        f.product.id,
        f.product.name,
        f.salePrice,
        f.stock,
        f.maxPerUser
    )
    FROM FlashSaleProduct f
""")
    List<FlashSaleProductDTO> findAllFlashSaleProducts();
}
