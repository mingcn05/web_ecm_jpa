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

import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class ShopCartController {

    @Autowired
    private ShoppingCart shoppingCart;
    @Autowired
    private ShopService shopService;

    @GetMapping("/addToCart")
    public String addToCart(Model model){
        model.addAttribute("CartItem", new CartItem());
        return "detail";
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@ModelAttribute("CartItem") CartItem c) {
            shoppingCart.addItem(c);
        return new ResponseEntity<>("success", HttpStatus.OK);


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

