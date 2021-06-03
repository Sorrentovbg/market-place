package ru.geekbrains.marketplace.msorder.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ElementCollection
    @CollectionTable(name = "orders_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name="product_id")
    private List<Long> productIds;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order(Long userId, List<Long> productIds){
        this.userId = userId;
        this.productIds = productIds;
        this.status = new Status();
    }
}
