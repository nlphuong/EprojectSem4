package com.shop.fashionShop.controller.user;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.enumeric.Gender;
import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Category;
import com.shop.fashionShop.model.Product;
import com.shop.fashionShop.model.viewModel.ProductCondition;
import com.shop.fashionShop.model.viewModel.Product_ProductDetail;
import com.shop.fashionShop.repository.BrandRepository;
import com.shop.fashionShop.repository.ProductRepository;
import com.shop.fashionShop.service.BrandService;
import com.shop.fashionShop.service.CategoryService;
import com.shop.fashionShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;
    @GetMapping("/product")
    public String index( @RequestParam(value = "category",required = false)String catName,
                         @RequestParam(value = "brand[]",required = false)String[] brands,
                         @RequestParam(value = "price_from",required = false)String price_from,
                         @RequestParam(value = "price_to",required = false)String price_to,
                         @RequestParam(value = "gender",required = false)String gender,
                         @RequestParam(value = "color",required = false)String color,
                         @RequestParam(value = "page",required = false)String page,
                         @RequestParam(value = "sort",required = false)String sort
            , Model model){
        Double from=price_from==null?null:Double.parseDouble(price_from);
        Double to=price_to==null?null:Double.parseDouble(price_to);
        Gender getGender=gender==null?null:Gender.valueOf(gender.toUpperCase(Locale.ROOT));
        Color getColor=color==null?null:Color.valueOf(color.toUpperCase(Locale.ROOT));
        Integer getPage=page==null?1:Integer.parseInt(page);
        Integer getSort=sort==null?1:Integer.parseInt(sort);
        ProductCondition productCondition=new ProductCondition(catName,brands,from,to, getGender , getColor,getPage,getSort);

        Page<Product> productPage=productService.findProductByMultiConditions(productCondition);
        List<Product> productList=productPage.getContent();
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("productCondition",productCondition);
        return "user/product/product";


    }

    @GetMapping("/product-detail")
    public String detail(){
        return "user/product/product-detail";
    }
}
