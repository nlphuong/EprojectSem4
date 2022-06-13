package com.shop.fashionShop.repository;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
    @Query("SELECT p FROM ProductDetail p WHERE p.product = ?1 and p.color =?2 and p.size=?3")
    ProductDetail findProductDetailByColorAndSize(Product product, Color color, String size);
}
