package com.example.webspringjpa.controller;


import com.example.webspringjpa.entity.Category;
import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.service.AdminService;
import com.example.webspringjpa.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService service;
    @Autowired
    private ShopService shopService;

    @GetMapping("/list_product")
    public String showProductsByCategory(Model model) {
        List<Product> pro = new ArrayList<>();
//        if (s.isEmpty()){
            pro = shopService.getAllProducts();
//        }else {
//            pro = shopService.getProductsByCategory(s);
//        }
        model.addAttribute("product", pro);
        return "list_product_admin";
    }
    @GetMapping("admin")
    public String admin(Model model){
        model.addAttribute("Product", new Product());
        return "admin";
    }
    @GetMapping("add_product")
    public String showAddProduct(Model model){
        model.addAttribute("Product", new Product());
        return "add_product";
    }
    @PostMapping("add_product")
    private String showAddProduct(@ModelAttribute("Product") Product prod){
        service.add_product(prod);
        return "admin";
    }
    @GetMapping("/delete/{id}")
    private String deleteProduct(@PathVariable Long id){
        service.delete_product(id);
        return "list_product_admin";
    }
    @GetMapping("update/{id}")
    public String update_product(@PathVariable Long id,Model model){
        Product p = shopService.getProductsById(id);
        model.addAttribute("Prod",p);
        model.addAttribute("Product", new Product());
        return "update_product";
    }
    @PostMapping("update")
    private String update_product(Product prod){
        service.update_product(prod);
        return "list_product_admin";
    }
    @GetMapping("add_category")
    public String addCategory(Model model){
        model.addAttribute("Category", new Category());
        return "add_category";
    }
    @PostMapping("add_category")
    private String addCategory(@ModelAttribute("Category") Category c){
        service.add_category(c);
        return "admin";
    }
}
