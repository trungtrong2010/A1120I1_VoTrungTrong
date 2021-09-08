package com.codegym.furama.controller;

import com.codegym.furama.model.entity.contract.Contract;
import com.codegym.furama.model.repository.customer.ICustomerRepository;
import com.codegym.furama.model.repository.employee.IEmployeeRepository;
import com.codegym.furama.model.repository.service.IServiceRepository;
import com.codegym.furama.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IServiceRepository serviceRepository;

    @Autowired
    private IContractService contractService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Contract> contracts = this.contractService.findAll();
//        List<Contract> contracts1 = new ArrayList<>();
//        for (Contract contract: contracts) {
//            contract.getStarDate().format(formatter);
//            contract.getEndDate().format(formatter);
//            contracts1.add(contract);
//        }
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("customers", this.customerRepository.findAll());
        model.addAttribute("employees", this.employeeRepository.findAll());
        model.addAttribute("services", this.serviceRepository.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/save";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("customers", this.customerRepository.findAll());
        model.addAttribute("employees", this.employeeRepository.findAll());
        model.addAttribute("services", this.serviceRepository.findAll());
        model.addAttribute("contract", this.contractService.findById(id));
        return "contract/save";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(value = "contract") Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model
//                       ,@RequestParam("starDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime starDate,
//                       @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
    ) {
        System.out.println("----" + contract.toString());
//        contract.setStarDate(starDate);
//        contract.setEndDate(endDate);
//        System.out.println(contract.toString());
        if (bindingResult.hasErrors()) {
            model.addAttribute("customers", this.customerRepository.findAll());
            model.addAttribute("employees", this.employeeRepository.findAll());
            model.addAttribute("services", this.serviceRepository.findAll());
            return "contract/save";
        }
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "Saved contract of customer name: " + this.customerRepository.findById(contract.getCustomer().getId()).get().getName());
        return "redirect:/contract/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("contract", this.contractService.findById(id));
        return "contract/detail";
    }

    @GetMapping("/delete/{id}")
    public String formDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("contract", this.contractService.findById(id));
        return "contract/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Integer id, RedirectAttributes redirectAttributes) {
        Contract contract = this.contractService.findById(id);
        this.contractService.delete(contract);
        redirectAttributes.addFlashAttribute("msg", "Deleted contract customer name: " + contract.getCustomer().getName());
        return "redirect:/contract/list";
    }
}
