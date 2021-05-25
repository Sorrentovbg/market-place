package ru.geekbrains.marketplace.msorder.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "cart_item_id")
    private List<CartItem> cartItems;


    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "order_created")
    private Long orderCreated;

    public Cart() {
        this.cartItems = new ArrayList<>();
        this.orderCreated = null;
    }
}
