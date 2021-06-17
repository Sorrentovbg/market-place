package ru.geekbrains.marketplace.msorder.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "status")
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orders_status")
    private String status;

}
