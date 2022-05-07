package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Color color;
    private String size;
    private double sell_price;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotEmpty(message = "Amount cannot blank!")
    private int amount;
    private Date createAt;
    private Date deleteAt;

}
