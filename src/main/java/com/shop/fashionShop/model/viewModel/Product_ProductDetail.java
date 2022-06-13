package com.shop.fashionShop.model.viewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product_ProductDetail {
    private String code;
    private Double sellPrice;

    public Product_ProductDetail(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
