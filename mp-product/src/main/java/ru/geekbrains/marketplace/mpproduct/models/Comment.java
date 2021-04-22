package ru.geekbrains.marketplace.mpproduct.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_comment_id")
    private Long product;

    @Column(name = "comment")
    private String comment;
}
