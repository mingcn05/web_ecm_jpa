package com.example.webspringjpa.controller;

import com.example.webspringjpa.entity.Comment;
import com.example.webspringjpa.entity.Product;
import com.example.webspringjpa.entity.User;
import com.example.webspringjpa.service.AdminService;
import com.example.webspringjpa.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CommentController {
    @Autowired
    private CommentService service;


    @PostMapping("comment")
    private String saveComment(@RequestParam("rating") BigDecimal rating, @RequestParam("product_id") int  product_id, @RequestParam("message") String message, HttpSession session) {
        User u = (User) session.getAttribute("user");
        Comment c = new Comment(product_id,u.getUsername(),message,rating);
        service.saveComment(c);
        return "detail";
    }
}
