package ru.geekbrains.marketplace.msorder.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "user_id")
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @Column(name = "total_price")
    private Integer totalPrice;


    public Cart() {
        this.cartItems = new ArrayList<>();
    }
}
