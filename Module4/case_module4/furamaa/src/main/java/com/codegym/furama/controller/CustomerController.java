package com.codegym.furama.controller;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.repository.customer.ICustomerRepository;
import com.codegym.furama.model.repository.customer.ICustomerTypeRepository;
import com.codegym.furama.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    public static HashMap<Integer, String> genders;

    static {
        genders = new HashMap<>();
        genders.put(0, "Female");
        genders.put(1, "Male");
        genders.put(2, "LGBT");
    }

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeRepository customerTypeService;

    @Autowired
    private ICustomerRepository customerRepository;

    @GetMapping("/list")
    public String showList(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "genderSearch", defaultValue = "-1") int genderSearch,
                           @RequestParam(value = "idTypeSearch", defaultValue = "-1") int idTypeSearch, Model model) {

        model.addAttribute("genders", genders);
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("genderSearch", genderSearch);
        model.addAttribute("idTypeSearch", idTypeSearch);

        Sort sort = Sort.by("name").and(Sort.by("date_of_birthday"));
        model.addAttribute("customers", this.customerService.findAllByNameContainingAndGenderAndCustomerType(
                nameSearch, genderSearch + "", idTypeSearch + "", PageRequest.of(page - 1, 3, sort)));
        return "customer/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("genders", genders);
        return "customer/save";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("customer", this.customerService.findById(id));
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        model.addAttribute("genders", genders);
        return "customer/save";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            model.addAttribute("genders", genders);
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
