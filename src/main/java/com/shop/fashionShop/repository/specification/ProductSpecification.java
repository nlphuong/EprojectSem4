package com.shop.fashionShop.repository.specification;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.enumeric.Gender;
import com.shop.fashionShop.model.*;
import com.shop.fashionShop.service.impl.ProductServiceImpl;
import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.criteria.*;
import javax.persistence.criteria.Order;
import java.util.*;

public class ProductSpecification {
    public static Specification<Product> hasProductName(String productName) {
        return (root, query, cb) -> cb.like(root.get(Product_.name),"%"+ productName+"%");
    }
    public static Specification<Product> hasProductCode(String productCode) {
        return (root, query, cb) -> cb.like(root.get(Product_.productCode),"%"+ productCode+"%");
    }
    public static Specification<Product> hasCategory(Category category) {
        return (root, query, cb) -> cb.equal(root.get(Product_.category), category);
    }
    public static Specification<Product> hasBrand(Brand brand) {
        return (root, query, cb) -> cb.equal(root.get(Product_.brand), brand);
    }
    public static Specification<Product> hasListBrand(List<Brand> brand) {
        return (root, query, cb) -> cb.in(root.get(Product_.BRAND)).value(brand);
    }
    public static Specification<Product> hasPrice(Double from,Double to,int typeSort) {
        return (root, query, cb) -> {
            Join<Product,ProductDetail> productProductDetailJoin=root.join("productDetailSet");
            List<Order> orders=new ArrayList<>();
            orders.add(cb.asc(productProductDetailJoin.get("sell_price")));
            if (typeSort== ProductServiceImpl.SORT_PRICE_ASC){
                query.distinct(true).orderBy(cb.asc(productProductDetailJoin.get("sell_price")));
            }

            if (typeSort==ProductServiceImpl.SORT_PRICE_DESC){
                query.distinct(true).orderBy(cb.desc(productProductDetailJoin.get("sell_price")));
            }
            return cb.between(productProductDetailJoin.get("sell_price"),from,to);
        };

    }
    public static Specification<Product> hasColor(Color color) {
        return (root, query, cb) -> {
            Join<Product,ProductDetail> productProductDetailJoin=root.join("productDetailSet");
            query.distinct(true);
            return cb.equal(productProductDetailJoin.get("color"),color);
        };
    }
    public static Specification<Product> hasGender(Gender gender) {
        return (root, query, cb) -> cb.in(root.get(Product_.GENDER)).value(Arrays.asList(gender,Gender.EVERYONE));
    }
    public static Specification<Object> distinct() {
        return (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
    }
}
