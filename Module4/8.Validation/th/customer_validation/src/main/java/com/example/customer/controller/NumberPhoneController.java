package com.example.customer.controller;

import com.example.customer.view.entity.PhoneNumber;
import com.example.customer.view.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NumberPhoneController {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "create";
    }

    @PostMapping("/save")
    private String save(@Valid @ModelAttribute PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        model.addAttribute("phoneNumber", phoneNumber.getNumber());
        this.phoneNumberRepository.save(phoneNumber);
        return "result";
    }
}
