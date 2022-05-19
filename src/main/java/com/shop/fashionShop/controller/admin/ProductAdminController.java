package com.shop.fashionShop.controller.admin;

import com.shop.fashionShop.enumeric.Status;
import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.ProductDetail;
import com.shop.fashionShop.repository.BrandRepository;
import com.shop.fashionShop.repository.ProductRepository;
import com.shop.fashionShop.service.BrandService;
import com.shop.fashionShop.service.CategoryService;
import com.shop.fashionShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("categoryList",categoryService.getAllCategory());
        model.addAttribute("product",new Product());
        model.addAttribute("brandList",brandService.findAll());
        model.addAttribute("listProductCode",productService.listProductCode());
        return "admin/product/add_product";
    }
    @PostMapping("/addProduct")
    public String postProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
        try {
            if (result.hasErrors()){
                model.addAttribute("categoryList",categoryService.getAllCategory());
                model.addAttribute("product",product);
                model.addAttribute("brandList",brandService.findAll());
                model.addAttribute("listProductCode",productService.listProductCode());
                return "admin/product/add_product";
            }
            else {
                product.setCreateAt(new Date());
                product.setStatus(Status.OUT_STOCK);
                Product newProduct= productService.save(product);
                return "redirect:/admin/productDetail/addProductDetail/"+newProduct.getProductCode();
            }
        }
        catch (Exception e){
            return "admin/product/add_product";
        }
    }
    @GetMapping("/productDetail")
    public String productDetail(){
        return "admin/product/add_product_detail";
    }
    @PostMapping("/postDetail")
    @ResponseBody
    public String postDetail(){
        return "success!";
    }

}
