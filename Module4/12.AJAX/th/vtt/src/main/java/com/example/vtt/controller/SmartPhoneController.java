package com.example.vtt.controller;

import com.example.vtt.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("smartPhones", this.smartPhoneService.findAll());
        return "list";
    }
}
