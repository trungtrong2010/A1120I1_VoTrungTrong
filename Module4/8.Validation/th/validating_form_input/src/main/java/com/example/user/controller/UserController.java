package com.example.user.controller;

import com.example.user.model.entity.User;
import com.example.user.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    private String save(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            this.userService.save(user);
            model.addAttribute("user", user);
            return "result";
        }
    }
}
