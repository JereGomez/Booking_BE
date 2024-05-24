package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginAndContentController {
    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "home_admin";
    }

    @GetMapping("/usuario/home")
    public String handleUserHome() {
        return "home_user";
    }
    @GetMapping("/logout")
    public String handlerLogout() {
        return "logout";
    }
}
