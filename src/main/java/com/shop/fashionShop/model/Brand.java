package com.shop.fashionShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "Brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Brand name can not blank!")
    @Column(nullable = false)
    private String name;
    private String description;
    @Lob
    private byte [] logo;
    @OneToMany(mappedBy = "brand",fetch = FetchType.EAGER)
    private Set<Product> productSet;

}
