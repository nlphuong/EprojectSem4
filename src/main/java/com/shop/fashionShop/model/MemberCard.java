package com.shop.fashionShop.model;

import com.shop.fashionShop.enumeric.Level;
import com.shop.fashionShop.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private String description;
   @Enumerated(EnumType.STRING)
   private Level level;
   private int point;
   @Enumerated(EnumType.STRING)
   private Status status;
   private Date createAt;
   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;
}
