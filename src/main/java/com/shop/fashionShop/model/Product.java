package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Gender;
import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    @NotEmpty(message = "Product name can not blank!")
    private String name;
    private String shortDescription;
    private String fullDescription;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Lob
    private byte[] image;
    @Column(nullable = false)
    @NotEmpty(message = "Price can not blank!")
    private Double price;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date createAt;
    private Date deleteAt;

}