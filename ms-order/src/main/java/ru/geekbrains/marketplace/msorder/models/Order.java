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

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order(Long userId, List<OrderItem> orderItems){
        this.userId = userId;
        this.orderItems = orderItems;
        this.status = new Status();
    }
}
