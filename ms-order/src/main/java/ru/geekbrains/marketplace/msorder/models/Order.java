package ru.geekbrains.marketplace.msorder.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(name = "product_id")
    private Long product_id;

    @ManyToOne
    @JoinTable(name = "order_status",
        joinColumns = @JoinColumn(name = "order_status"))
    private Status status;

}
