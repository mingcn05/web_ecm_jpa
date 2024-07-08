package com.example.webspringjpa.controller;


import com.example.webspringjpa.entity.User;
import com.example.webspringjpa.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("User", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("User") User user,Model model, HttpSession session) {
        // Kiểm tra thông tin đăng nhập
        User u = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (u != null) {
            // Lưu thông tin phiên làm việc
            session.setAttribute("userId", u.getId());
            return "redirect:/index"; // Chuyển hướng đến trang chính của ứng dụng
        } else {
            model.addAttribute("mess","Thông tin tài khoản hoặc mật khẩu không chính xác");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Xóa thông tin phiên làm việc khi người dùng đăng xuất
        session.removeAttribute("userId");
        return "redirect:/login"; // Chuyển hướng về trang đăng nhập
    }
}
