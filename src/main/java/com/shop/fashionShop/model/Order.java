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
@Table(name = "order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date orderTime;
    private Date deliveredDate;
    private String note;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String fullName;
    private String address;
    private String phone;
}
