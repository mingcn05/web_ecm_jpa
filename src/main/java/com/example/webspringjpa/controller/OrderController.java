package com.example.webspringjpa.controller;

import com.example.webspringjpa.entity.CartItem;
import com.example.webspringjpa.entity.OrderItem;
import com.example.webspringjpa.entity.Orders;
import com.example.webspringjpa.entity.User;
import com.example.webspringjpa.service.OrderItemService;
import com.example.webspringjpa.service.OrderService;
import com.example.webspringjpa.service.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private ShoppingCart shoppingCart;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/check_out")
    public String payment(@RequestParam("addr") String addr, Model model, HttpSession session) {
        List<CartItem> cart = shoppingCart.getItems();

        int totalPrice = 0;
        String status = "Processing";
        for (CartItem item : cart) {
            int itemPrice = (int) item.getProduct().getPrice();
            int itemQuantity = item.getQuantity();
            int totalPriceForItem = itemPrice * itemQuantity;
            totalPrice += totalPriceForItem;
        }
        User user = (User) session.getAttribute("user");

        if (user != null) {
            LocalDateTime time = LocalDateTime.now();
            Orders order = new Orders(user.getUsername(), time, totalPrice, status, addr);
            Orders o = orderService.addOrder(order);


            for (CartItem item : cart) {
                int itemPrice = (int) item.getProduct().getPrice();
                int itemQuantity = item.getQuantity();
                int totalPriceForItem = itemPrice * itemQuantity;
                OrderItem order_Items = new OrderItem(o.getId(), (int) item.getProduct().getId(), itemQuantity, totalPriceForItem);

                orderItemService.addOrderItem(order_Items);
            }
            return "redirect:/";
        } else {
            String error = "Đăng nhập để checkout!";
            model.addAttribute("error", error);
            return "redirect:/login";
        }

    }


}
