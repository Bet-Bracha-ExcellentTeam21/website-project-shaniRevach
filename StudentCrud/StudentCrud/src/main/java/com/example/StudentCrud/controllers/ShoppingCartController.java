package com.example.StudentCrud.controllers;

import com.example.StudentCrud.domain.Item;
import com.example.StudentCrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * The shopping cart controller.
 */
@Controller
@RequestMapping (path = "/shoppingCart")
public class ShoppingCartController {

    private final ProductService productService; //The product services.

    @Autowired
    public ShoppingCartController(ProductService productService){

        this.productService = productService;
    }

    /**
     * Add product to the shopping cart.
     * @param id The id of the product to be added to cart.
     * @param session The session of each user.
     * @return List of item in the shopping cart.
     */
    @GetMapping(path = "/addProduct/{id}")
    public String addToCart(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(productService.get(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(productService.get(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "shopping-cart";
    }

    /**
     * remove product from the shopping cart.
     * @param id The id of the product to be removed from the cart.
     * @param session The session of each user.
     * @return List of item in the shopping cart.
     */
    @GetMapping("/removeProduct/{id}")
    public String remove(@PathVariable("id") Long id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "shopping-cart";
    }

    /**
     * Check if the product already exist in the shopping cart.
     * @param id The id of the product to be checked.
     * @param cart The shopping cart to search there.
     * @return Positive number if the product exist and negative if not.
     */
    private int exists(Long id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == (id)) {
                return i;
            }
        }
        return -1;
    }

}
