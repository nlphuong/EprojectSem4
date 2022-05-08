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
import java.util.Set;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Email can not blank!")
    @Column(name = "email",unique = true,nullable = false)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    @Column(name = "password",nullable = true)
    private String password;
    @Column(name = "full_name")
    private String fullName;
    private String phone;
    @Lob
    @Column(nullable = true,length = Integer.MAX_VALUE)
    private byte[] avatar;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private LoginBy loginBy;
    private Date createdAt;
    private Date deletedAt;

    //region relationship
    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<Rating> ratingSet;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<AnswerQuestion>  answerQuestions;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<CartItem>  cartItemSet;
    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<AddressOrder> addressOrderSet;
    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<Order> orderSet;
    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<Voucher> voucherSet;
    @OneToOne(mappedBy = "account")
    private MemberCard memberCard;
    //endregion
}
