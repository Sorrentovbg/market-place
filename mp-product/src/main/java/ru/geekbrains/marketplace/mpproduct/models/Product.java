package ru.geekbrains.marketplace.mpproduct.models;

import lombok.Data;

import javax.persistence.*;
import java.net.URL;
import java.util.Collection;

@Entity
@Data
@Table(name = "product")
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int product_price;

    @Column(name = "product_picture")
    private URL url_picture;

    @OneToMany
    @JoinTable(name = "product_item",
            joinColumns = @JoinColumn(name = "product_item_id"))
    private Collection <ProductItem> productItems;

    @OneToMany
    @JoinTable(name = "product_comment",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Collection <Comment> comments;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Collection <Category> productCategory;
}
