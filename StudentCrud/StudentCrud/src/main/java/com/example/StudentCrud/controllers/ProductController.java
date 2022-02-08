package com.example.StudentCrud.product;

import com.example.StudentCrud.domain.Product;
import com.example.StudentCrud.domain.ResponseTransfer;
import com.example.StudentCrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping( "/search")
    public String searchProduct(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = productService.listAll(keyword);
        model.addAttribute("listProducts", listProducts);

        return "results";
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public ResponseTransfer postResponseController(@RequestBody Product product) {
        Product newProduct = taskRepo.save(product);
        return new ResponseTransfer("The product was successfully added");
    }
}
