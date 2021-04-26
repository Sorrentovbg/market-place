package ru.geekbrains.marketplace.mspayment.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cashback")
public class CashBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cashback_id")
    private Long id;

    @Column(name = "cashback")
    private Long cashBack;

}
