package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerSecurity {


    @GetMapping("/welcome")
    public String index() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
