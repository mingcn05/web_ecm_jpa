package com.example.webspringjpa.controller;


import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.service.SearchService;
import com.example.webspringjpa.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ShopController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private SearchService searchProducts;

    @GetMapping("/search")
    public String searchProducts(@RequestParam("name") String keyword, Model model) {
        // Thực hiện tìm kiếm sản phẩm trong cơ sở dữ liệu dựa trên từ khóa
        List<Product> products = searchProducts.getProductByKeyWord(keyword);

        // Đưa danh sách sản phẩm tìm được vào model để hiển thị trên giao diện
        model.addAttribute("product", products);

        // Trả về view hiển thị kết quả tìm kiếm
        return "shop";
    }


    @GetMapping("/shop")
    public String showProductsByCategory(Model model, @ModelAttribute("category") String s) {
        List<Product> pro = new ArrayList<>();

        if(s.isEmpty()){
            pro = shopService.getAllProducts();
        }else {
            pro = shopService.getProductByCategory(s);
        }
        model.addAttribute("product", pro);
        return "shop";
    }
    @GetMapping("/detail/{id}")
    public String showProductDetail(@PathVariable Long id, Model model){
        Product prod =shopService.getProduct(id);
        model.addAttribute("product",prod);
        return "detail";

    }



}
