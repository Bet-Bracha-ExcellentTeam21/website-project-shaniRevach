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


/**
 * The product controller.
 */
@Controller
public class ProductController {

    private final ProductService productService; //The product services.

    @Autowired
    public ProductController(ProductService productService){

        this.productService = productService;
    }

    /**
     * Display the products on the home page - "index".
     * @param model
     * @return List of all products.
     */
    @GetMapping("/index")
    public String viewHomePage(Model model) {
        List<Product> listProducts = productService.listAll("");
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    /**
     * Search for product by keyword.
     * @param model
     * @param keyword The keyword to search by.
     * @return List of all products found.
     */
    @GetMapping( "/search")
    public String searchProduct(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = productService.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        return "results";
    }

    /**
     * Add a new product to stock.
     * @param product The new product.
     * @return Message that the product was successfully added.
     */
    @PostMapping("/addProductToStock")
    @ResponseBody
    public ResponseTransfer addProductToStock(@RequestBody Product product) {
        productService.save(product);
        return new ResponseTransfer("The product was successfully added");
    }

    /**
     * remove exist product from the stock.
     * @param id The id of the product to be removed.
     * @return Message that the product was successfully removed.
     */
    @PostMapping("/removeProductFromStock")
    @ResponseBody
    public ResponseTransfer removeProductFromStock(@Param("id") Long id) {
        productService.delete(id);
        return new ResponseTransfer("The product was successfully removed");
    }

}
