package com.example.vtt.controller;

import com.example.vtt.model.entity.SmartPhone;
import com.example.vtt.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("smartPhones", this.smartPhoneService.findAll());
        return "list";
    }

    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("smartPhone", new SmartPhone());
        return "create";
    }

    @PostMapping("/create")
    public ResponseEntity<SmartPhone> createCustomer(@RequestBody SmartPhone smartPhone, BindingResult bindingResult) {
        this.smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model, @PathVariable("id") int id) {
        model.addAttribute("smartPhone", this.smartPhoneService.findById(id));
        return "edit";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") int id) {
        model.addAttribute("smartPhone", this.smartPhoneService.findById(id));
        return "detail";
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<SmartPhone> delete(@PathVariable("id") int id, Model model) {
        SmartPhone smartPhone = this.smartPhoneService.findById(id);
        this.smartPhoneService.remove(smartPhone);
        model.addAttribute("smartPhone", smartPhone);
        return new ResponseEntity<>(smartPhone, HttpStatus.OK);
    }
}
