package com.shop.fashionShop.repository;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
