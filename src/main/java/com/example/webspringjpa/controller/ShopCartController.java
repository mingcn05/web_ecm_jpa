package com.example.webspringjpa.controller;

import com.example.webspringjpa.entity.CartItem;
import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.service.ShopService;
import com.example.webspringjpa.service.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class ShopCartController {

    @Autowired
    private ShoppingCart shoppingCart;
    @Autowired
    private ShopService shopService;

//    @GetMapping("/addToCart")
//    public String addToCart(Model model){
//        model.addAttribute("CartItem", new CartItem());
//        return "detail";
//    }

    @PostMapping("/add_to_cart")
    public String addToCart(@RequestParam("id") Long id,@RequestParam("quantity") int quantity,HttpSession session) {
        Product product = shopService.getProductsById(id);
        CartItem cartItem = new CartItem(product, quantity);
        List<CartItem> cart = shoppingCart.getItems();
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        boolean itemExists = false;
        for (CartItem item : cart) {
            if (item.getProduct().getId() == id) {
                item.setQuantity(item.getQuantity() + quantity);
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cart.add(cartItem);
        }

        return "cart";


    }
    @GetMapping("/cart")
    public String showCart(Model model){
        List<CartItem> cartItems = shoppingCart.getItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }
    @GetMapping("checkout")
    public String checkout(Model model){
        List<CartItem> cartItems = shoppingCart.getItems();
        model.addAttribute("cartItems", cartItems);
        return "paypal/test";
    }
}

