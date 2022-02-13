package com.example.StudentCrud.controllers;

import com.example.StudentCrud.domain.Product;
import com.example.StudentCrud.domain.ResponseTransfer;
import com.example.StudentCrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/index")
    public String viewHomePage(Model model) {
        List<Product> listProducts = productService.listAll("");
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @GetMapping( "/search")
    public String searchProduct(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = productService.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        return "results";
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public ResponseTransfer addProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseTransfer("The product was successfully added");
    }

    @PostMapping("/removeProduct")
    @ResponseBody
    public ResponseTransfer removeProduct(@Param("id") Long id) {
        productService.delete(id);
        return new ResponseTransfer("The product was successfully removed");
    }
}