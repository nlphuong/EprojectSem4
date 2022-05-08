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
import java.util.Set;

@Entity
@Table(name = "orders")
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
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetailSet;
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private Set<OrderTrack> orderTrackSet;
    @OneToOne(mappedBy = "order")
    private Invoice invoice;
}
