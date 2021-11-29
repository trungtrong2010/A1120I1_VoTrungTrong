package com.example.demo.controller;

import com.example.demo.model.entity.Transaction;
import com.example.demo.model.repository.ICustomerRepository;
import com.example.demo.model.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerRepository customerRepository;

    public static HashMap<Integer, String> types;
    static {
        types = new HashMap<>();
        types.put(1, "Đất");
        types.put(2, "Nhà đất");
    }

    @GetMapping(value = {"", "/list"})

    public String showList(Model model) {
        model.addAttribute("transactions", this.transactionService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types);
        model.addAttribute("customers", this.customerRepository.findAll());
        model.addAttribute("transaction", new Transaction());
        return "create";
    }
}
