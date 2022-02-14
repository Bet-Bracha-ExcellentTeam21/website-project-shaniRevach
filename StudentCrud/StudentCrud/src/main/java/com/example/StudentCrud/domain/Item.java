package com.example.StudentCrud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * Item for each type of product in the shopping cart.
 */
@AllArgsConstructor
@Getter
@Setter
public class Item {

    private Product product; //The product
    private int quantity; //The quantity of the product.

}
