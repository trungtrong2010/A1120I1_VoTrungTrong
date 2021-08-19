package com.codegym.vtt.controller;

import com.codegym.vtt.model.entity.Product;
import com.codegym.vtt.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("cart")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /*add cart in model attribute*/
    @ModelAttribute("cart")
    public List<Product> setCartProduct() {
        return new ArrayList<>();
    }

    @GetMapping("/list")
    public String listProduct(Model model) {
        model.addAttribute("products", this.productService.findAll());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "detail";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") int id, RedirectAttributes redirectAttributes,
                            @ModelAttribute(name = "cart") List<Product> cart) {
        cart.add(this.productService.findById(id));
        redirectAttributes.addFlashAttribute("message", "Add to cart successfully!");
        return "redirect:/product/list";
    }

    @GetMapping("/cart")
    public String shoppingCart(@ModelAttribute("cart") List<Product> cart, Model model) {
        model.addAttribute("cartList", cart);
        return "cart";
    }

//    @GetMapping("/deleteCart/{id}")
//    public String deleteCart()
}
