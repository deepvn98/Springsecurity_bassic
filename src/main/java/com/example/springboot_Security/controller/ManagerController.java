package com.example.springboot_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security/")
public class ManagerController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

}
