package com.shop.fashionShop.model;

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
@Table(name = "promotion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String promotionCode;
   private Date dateStart;
   private Date dateEnd;
   @NotNull(message = "Please input discount")
   private double discount;
   @Enumerated(EnumType.STRING)
   private Status status;
   private Date createAt;
   @OneToMany(mappedBy = "promotion",fetch = FetchType.EAGER)
   private Set<ProductDetail> productDetailSet;
}
