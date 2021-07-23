package controller;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"", "/customer"})
    private String showList(Model model) {
        model.addAttribute("list", customerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

//    @PostMapping("/createCustomer")
//////    private String saveCustomer(@ModelAttribute Customer customer, Model model) {
//////        customerService.save(customer);
//////        return showList(model);
//////    }

    @PostMapping("/createCustomer")
    private String saveCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    //@RequestParam
    @GetMapping("/show")
    private String showFormShow(@RequestParam int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "show";
    }

    //@PathVariable
    @GetMapping("/{id}/edit")
    private String showFormEdit(@PathVariable int id, Model model) { //PathVariable
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/editCustomer")
    private String updateCustomer(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    private String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }

    @PostMapping("/deleteCustomer")
    private String delete(Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customer";
    }
}
