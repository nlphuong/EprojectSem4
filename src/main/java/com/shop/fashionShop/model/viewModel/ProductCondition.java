package com.shop.fashionShop.model.viewModel;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.enumeric.Gender;
import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCondition {
    private String catName;
    private String[] brandName;
    private Double price_from;
    private Double price_to;
    private Gender gender;
    private Color color;
    private int page;
    private int orderSort=1;





}
