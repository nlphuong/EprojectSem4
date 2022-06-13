package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private double price;
    private Date createAt;
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    public Inventory(int amount, double price, Date createAt, ProductDetail productDetail) {
        this.amount = amount;
        this.price = price;
        this.createAt = createAt;
        this.productDetail = productDetail;
    }
}
