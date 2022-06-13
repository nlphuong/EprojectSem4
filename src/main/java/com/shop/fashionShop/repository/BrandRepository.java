package com.shop.fashionShop.repository;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    @Query("SELECT b FROM Brand b WHERE b.name=?1")
    public Brand getBrandByName(String name);
    @Query("SELECT b FROM Brand b WHERE b.name IN (?1)")
    public List<Brand> getBrandByListName(String [] names);
}
