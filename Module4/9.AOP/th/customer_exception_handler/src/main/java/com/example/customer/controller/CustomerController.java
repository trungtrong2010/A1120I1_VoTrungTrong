package com.example.customer.controller;

import com.example.customer.model.entity.Customer;
import com.example.customer.model.service.ICustomerService;
import com.example.customer.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    private String[] arrGender = new String[]{"Female", "Male", "LGBT"};

    @GetMapping("/list")
    private String showList(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "idProvince", defaultValue = "0") int idProvince,
                            @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch, Model model) {
        Sort sort = Sort.by("name").and(Sort.by("gender")).descending();
        model.addAttribute("provinces", provinceService.findAll());
        model.addAttribute("idProvince", provinceService.findById(idProvince));
        model.addAttribute("nameSearch", nameSearch);
        if (nameSearch.equals("")) {
            if (idProvince == 0) {
                model.addAttribute("list", customerService.findAll(PageRequest.of(page - 1, 20, sort)));
            } else {
                model.addAttribute("list", customerService.findAllByProvinceId(idProvince, PageRequest.of(page - 1, 3, sort)));
            }
        } else {
            model.addAttribute("list", customerService.findAllByProvince_IdAndNameContaining(idProvince, nameSearch, PageRequest.of(page - 1, 3, sort)));
//            model.addAttribute("list", customerService.findByNameContaining(nameSearch, PageRequest.of(page - 1, 3, sort)));
        }
        return "list";
    }

//    @GetMapping("/search")
//    private String search(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch, Model model) {
//        Sort sort = Sort.by("name").and(Sort.by("id")).ascending();
//        model.addAttribute("nameSearch", nameSearch);
//        model.addAttribute("list", customerService.findByNameContaining(nameSearch, PageRequest.of(page - 1, 2, sort)));
//        return "list";
//    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("listGender", arrGender);
        model.addAttribute("listProvince", provinceService.findAll());
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    private String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/detail")
    private String detail(@RequestParam int id, Model model) {
        model.addAttribute("listGender", arrGender);
        model.addAttribute("customer", customerService.findById(id));
        return "detail";
    }

    @GetMapping("/{id}/edit")
    private String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("listGender", arrGender);
        model.addAttribute("listProvince", provinceService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    private String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/delete")
    private String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("listGender", arrGender);
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("/remove")
    private String remove(Customer customer) {
        customerService.remove(customer);
        return "redirect:/customer/list";
    }
}
