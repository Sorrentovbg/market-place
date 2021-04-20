package ru.geekbrains.marketplace.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private Long id;

    @Column(name = "username")
    private String  username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinTable(name = "user_cashback",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "cashback_id"))
    private CashBack cashBacks;

    @OneToMany
    @JoinTable(name = "orders",
        joinColumns = @JoinColumn(name = "orders_id"))
    private Collection<Order> order;



}
