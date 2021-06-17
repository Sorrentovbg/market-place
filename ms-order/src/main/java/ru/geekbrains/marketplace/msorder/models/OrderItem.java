package ru.geekbrains.marketplace.msorder.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders_item")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price_per_product")
    private int pricePerProduct;

    @Column(name = "count_product")
    private int countProduct;

    @Column(name = "total_price_product")
    private int  totalPriceProduct;

    public OrderItem(Long productId, String productName, int pricePerProduct, int count, int totalPriceProduct) {
        this.productId = productId;
        this.productName = productName;
        this.pricePerProduct = pricePerProduct;
        this.countProduct = count;
        this.totalPriceProduct = totalPriceProduct;
    }
}
