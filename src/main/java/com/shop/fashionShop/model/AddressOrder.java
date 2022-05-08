package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.LoginBy;
import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "address_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Account account;
    private String fullName;
    private String address;
    private String phone;

}
