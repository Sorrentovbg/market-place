package ru.geekbrains.marketplace.mscore.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinColumn(name = "role_id")
    private Role role;


//    @OneToOne
//    @JoinTable(name = "user_cashback",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "cashback_id"))
//    private CashBack cashBacks;

//    @OneToMany
//    @JoinTable(name = "orders",
//            joinColumns = @JoinColumn(name = "orders_id"))
//    private Collection<Order> order;
}