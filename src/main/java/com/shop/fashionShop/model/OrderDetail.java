package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_detail_id",nullable = false)
    private ProductDetail productDetail;
    @Column(nullable = false)
    private double unitPrice;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double discount;
}
