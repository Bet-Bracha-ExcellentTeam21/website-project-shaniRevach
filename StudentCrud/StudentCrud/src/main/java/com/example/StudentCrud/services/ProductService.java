package com.example.StudentCrud.services;

import com.example.StudentCrud.domain.Product;
import com.example.StudentCrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public Product get(long id) {
        return productRepository.findById(id).get();
    }


}
