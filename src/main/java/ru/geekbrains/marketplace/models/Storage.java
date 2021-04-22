package ru.geekbrains.marketplace.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_id")
    private Long product;

    @Column(name = "storage_name")
    private String storageName;

    @Column(name = "storage_address")
    private String address;
}
