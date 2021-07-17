package controller;

import service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer")
    private String showList(Model model) {
        model.addAttribute("list", customerService.findAll());
        return "list";
    }
}
