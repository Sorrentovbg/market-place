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
    private int productPrice;

    @Column(name = "product_picture")
    private String urlPicture;

    public Product(String name, int price, String picture) {
        this.productName = name;
        this.productPrice = price;
        this.urlPicture = picture;
    }

}


