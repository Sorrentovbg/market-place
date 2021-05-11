//package ru.geekbrains.marketplace.msproduct.models;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Entity
//@Data
//@Table(name = "product_item")
//public class ProductItem extends Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "product_item_id")
//    private Long product;
//
//    @Column(name = "description")
//    private String description;
//
////    @OneToMany
////    @JoinTable(name = "product_item_storage",
////        joinColumns = @JoinColumn(name = "product_item_id"),
////        inverseJoinColumns = @JoinColumn(name = "storage_id"))
////        private Collection<Storage> storages;
//
//}
