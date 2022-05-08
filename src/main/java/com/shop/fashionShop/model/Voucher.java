package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @Column(nullable = false)
   private String voucherCode;
   private String description;
   private double conditionPrice;
   private Date expirationDate;
   private Date applyDate;
   @Enumerated(EnumType.STRING)
   private Status status;
   private Date createAt;
   @ManyToOne
   @JoinColumn(name = "account_id")
   private Account account;
}
