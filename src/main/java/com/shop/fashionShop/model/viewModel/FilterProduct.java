package com.shop.fashionShop.model.viewModel;

import com.shop.fashionShop.model.Brand;
import com.shop.fashionShop.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterProduct {
    private String productCode;
    private String productName;
    private Category category;
    private Brand brand;
}
