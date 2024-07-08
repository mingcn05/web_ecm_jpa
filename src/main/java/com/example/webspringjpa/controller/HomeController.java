package com.example.webspringjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "index";
    }
    @GetMapping("test")
    public String test(){
        return "paypal/test";
    }
    @GetMapping("contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("detail")
    public String detail(){
        return "detail";
    }


}
