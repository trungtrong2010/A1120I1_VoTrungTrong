package com.example.demo.controller;

import com.example.demo.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping(value = {"/", "/list"})
    private String list(Model model) {
        model.addAttribute("smartPhones", smartPhoneService.findAll());
        return "list";
    }
}
