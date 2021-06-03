package ru.geekbrains.marketplace.msproduct.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int product_price;

    @Column(name = "product_picture")
    private String url_picture;

    public Product(String name, int price, String picture) {
        this.productName = name;
        this.product_price = price;
        this.url_picture = picture;
    }
//    @OneToMany
//    @JoinTable(name = "product_item",
//            joinColumns = @JoinColumn(name = "product_item_id"))
//    private Collection <ProductItem> productItems;

//    @OneToMany
//    @JoinTable(name = "product_comment",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "comment_id"))
//    private Collection <Comment> comments;

//    @ManyToMany
//    @JoinTable(name = "product_category",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private Collection <Category> productCategory;

}


