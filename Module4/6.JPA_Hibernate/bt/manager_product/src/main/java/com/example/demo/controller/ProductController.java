package com.example.demo.controller;


import com.example.demo.model.entity.Product;
import com.example.demo.model.service.IProductService;
import com.example.demo.model.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/product")
@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping(value = {"/", "/list"})
    private String showListProduct(Model model) {
        model.addAttribute("list", productService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    private String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listTypeProduct", typeProductService.findAll());
        return "create";
    }

    @PostMapping(value = "/save")
    private String save(Product product) {
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping(value = "/detail")
    private String detail(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @GetMapping(value = "/{id}/delete")
    private String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping(value = "/remove")
    private String remove(Product product) {
        productService.remove(product);
        return "redirect:/product/list";
    }
}
