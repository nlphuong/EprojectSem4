package com.shop.fashionShop.repository;

import com.shop.fashionShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT  c FROM Category c WHERE c.name =?1")
    public Category findByName(String name);
}
