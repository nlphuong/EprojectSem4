package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Color;
import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Color color;
    private String size;
    private double sell_price;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull(message = "Amount cannot blank!")
    private int quantity;
    private Date createAt;
    private Date deleteAt;
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
    @OneToMany(mappedBy = "productDetail")
    private Set<OrderDetail> orderDetailSet;
    @OneToMany(mappedBy = "productDetail")
    private Set<CartItem> cartItemSet;
    @OneToMany(mappedBy = "productDetail",fetch = FetchType.EAGER)
    private Set<ProductImage> productImageSet;
    @OneToMany(mappedBy = "productDetail",fetch = FetchType.EAGER)
    private Set<Inventory> inventorySet;

    public ProductDetail(int id) {
        this.id = id;
    }
}
