package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.ProductDetail;
import com.shop.fashionShop.model.ProductImage;
import com.shop.fashionShop.service.ProductDetailService;
import com.shop.fashionShop.service.ProductImageService;
import com.shop.fashionShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/productImage")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/display/{id}")
    public void displayImage(@PathVariable("id") int id, HttpServletResponse httpServletResponse) throws IOException {
        ProductImage productImage=productImageService.findOne(id);
        httpServletResponse.getOutputStream().write(productImage.getImage());
        httpServletResponse.getOutputStream().close();
    }
}
