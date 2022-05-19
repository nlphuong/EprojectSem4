package com.shop.fashionShop.controller.user;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.repository.BrandRepository;
import com.shop.fashionShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @GetMapping("/product")
    public String index(){
        Brand brand=new Brand();
        brand.setName("brand1");
        brand.setDescription("description for brand1");
        Brand brand1=brandRepository.save(brand);
        System.out.println(brand1.getId());
        return "user/product/product";
    }

    @GetMapping("/product-detail")
    public String detail(){
        return "user/product/product-detail";
    }
}
