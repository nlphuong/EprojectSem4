package com.shop.fashionShop.repository;

import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.viewModel.Product_ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {
    @Query("SELECT p FROM Product p WHERE p.productCode = ?1")
    Product getProductByCode(String code);
    @Query("SELECT p FROM Product p WHERE p.category.name= ?1")
    List<Product> getProductByCategoryName(String catName);
    @Query(value = "SELECT new com.shop.fashionShop.model.viewModel.Product_ProductDetail(pd.product.name,min(pd.sell_price)) FROM ProductDetail pd join Product p on pd.product.id = p.id group by pd.product.name")
    List<Product_ProductDetail> get();
    @Query("SELECT min(pd.sell_price) FROM ProductDetail pd WHERE pd.product=?1")
    Double minPrice(Product product);

}
