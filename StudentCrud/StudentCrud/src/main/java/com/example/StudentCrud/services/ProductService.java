package com.example.StudentCrud.services;

import com.example.StudentCrud.domain.Product;
import com.example.StudentCrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * The services of the product.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository; //Repository for search exist products by keyword.

    /**
     * Search exist products by keyword.
     * @param keyword The keyword to search by.
     * @return List of all products found.
     */
    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return productRepository.findAll(keyword);
        }
        return productRepository.findAll();
    }

    /**
     * Add a new product to the stock.
     * @param product The new product.
     */
    public void save(Product product) {
        productRepository.save(product);
    }

    /**
     * remove exist product from the stock.
     * @param id The id of the product to be removed.
     */
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    /**
     * Search exist product by id.
     * @param id The id of the product to be searched.
     * @return The founded product.
     */
    public Product get(long id) {
        return productRepository.findById(id).get();
    }

}
