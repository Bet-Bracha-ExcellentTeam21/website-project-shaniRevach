package com.example.StudentCrud.domain;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "image_path",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String imagePath;

    @Column(name = "price")
    private Integer price;

    public Product() {

    }

    public Product(String name, String imagePath, Integer price) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}