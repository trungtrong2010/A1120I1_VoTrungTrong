package com.codegym.furama.controller;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.service.customer.ICustomerService;
import com.codegym.furama.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showList(Model model) {
//        Sort sort =Sort.by("name").and(Sort.by("dateOfBirthday"));
//        model.addAttribute("customers", this.customerService.findAll(PageRequest.of(page-1,2,)))
        model.addAttribute("customers", this.customerService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("genders", LoginController.genders);
        return "customer/save";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("genders", LoginController.genders);
        return "customer/save";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            model.addAttribute("genders", LoginController.genders);
            return "customer/save";
        }
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Added/Update new ok name customer: " + customer.getName());
        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        model.addAttribute("checkDetail", "detail");
        return "customer/delete";
    }



    @GetMapping("/{id}/remove")
    public String showFormDelete(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute(name = "customer") Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.remove(customer);
        redirectAttributes.addFlashAttribute("msg", "Deleted ok name customer: " + customer.getName());
        return "redirect:/customer/list";
    }
}
