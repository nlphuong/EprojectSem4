package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.enumeric.Color;
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

import javax.servlet.http.HttpServletResponse;
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
    @PostMapping("/updateProductDetail")
    public String updateProductDetail(@RequestParam("id") int id,@RequestParam("size") String size,@RequestParam("color") String color,@RequestParam("quantity")int quantity, @RequestParam("images") MultipartFile [] files, Model model) throws IOException {
        ProductDetail productDetail= productDetailService.findOne(id);
        productDetail.setSize(size);
        productDetail.setColor(Color.valueOf(color));
        productDetail.setQuantity(quantity);
        productDetailService.update(productDetail,files);
        return "redirect:/admin/product/detail/"+productDetail.getProduct().getId();

    }
    @GetMapping("/productDetailLayout/{code}")
    public String productDetailLayout(@PathVariable String code,Model model){
        ProductDetail productDetail=new ProductDetail();
        Product product=productService.findByProductCode(code);
        productDetail.setProduct(product);
        productDetail.setSell_price(product.getPrice());
        model.addAttribute("productDetail",productDetail);
        model.addAttribute("product",product);
        return "admin/product/add_product_detail";
    }

}
