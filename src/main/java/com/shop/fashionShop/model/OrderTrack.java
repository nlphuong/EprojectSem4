package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_track")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @ManyToOne
   @JoinColumn(name = "order_id")
   private Order order;
   @Enumerated(EnumType.STRING)
   private Status status;
   private Date createAt;
}
