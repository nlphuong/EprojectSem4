package com.shop.fashionShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "articles_image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "articles_id")
    private Articles articles;
    private String name;
    @Lob
    private byte[] image;

}
