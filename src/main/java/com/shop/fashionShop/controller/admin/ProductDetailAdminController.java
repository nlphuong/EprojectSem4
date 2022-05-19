package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.enumeric.Status;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.ProductDetail;
import com.shop.fashionShop.service.ProductDetailService;
import com.shop.fashionShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/admin/productDetail")
public class ProductDetailAdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDetailService productDetailService;
    @GetMapping("/addProductDetail/{code}")
    public String productDetail(@PathVariable("code") String code, Model model){
        ProductDetail productDetail=new ProductDetail();
        Product product=productService.findByProductCode(code);
        productDetail.setProduct(product);
        productDetail.setSell_price(product.getPrice());
        model.addAttribute("productDetail",productDetail);
        model.addAttribute("product",product);
        return "admin/product/add_product_detail_afterSubmit";
    }
    @PostMapping("/postProductDetail")
    public String postProductDetail(@Valid @ModelAttribute("productDetail")ProductDetail productDetail, @RequestParam("images") MultipartFile [] files, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()){
            model.addAttribute("productDetail",productDetail);
            model.addAttribute("product",productDetail.getProduct());
            return "admin/product/add_product";
        }
        else {
            ProductDetail newProductDetail= productDetailService.save(productDetail,files);
            return "redirect:/admin/productDetail/addProductDetail/"+productDetail.getProduct().getProductCode();
        }
    }
}
