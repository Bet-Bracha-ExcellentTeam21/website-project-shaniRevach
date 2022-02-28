package com.example.StudentCrud.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


/**
 * The products of the store.
 */
@Getter
@Setter
@Entity
@Table(name = "products")
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
    private Long id; //The id of the product.

    @Column(
            name = "name",
            nullable = false
    )
    private String name; //The name of the product.

    @Column(
            name = "image_path",
            nullable = false
    )
    private String imagePath; //The image path of the product.

    @Column(name = "price")
    private double price; //The price of the product.

    public Product() {}

    public Product(String name, String imagePath, double price) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

}