package com.example.customer.controller;

import com.example.customer.model.entity.Customer;
import com.example.customer.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customerRest")
public class CustomerControllerREST {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> showList(@RequestParam(value = "page", defaultValue = "1") int page) {
        Sort sort = Sort.by("name").and(Sort.by("gender")).descending();
        Page<Customer> customerPage = customerService.findAll(PageRequest.of(page - 1, 3, sort));
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Customer customer = this.customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerService.remove(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/edit")
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody Customer customer) {
        Customer customerEdit = this.customerService.findById(id);
        if (customerEdit == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        customerEdit.setName(customer.getName());
//        customerEdit.setDateOfBirthday(customer.getDateOfBirthday());
//        customerEdit.setGender(customer.getGender());
//        customerEdit.setProvince(customer.getProvince());
        customerEdit = customer;
        this.customerService.save(customerEdit);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
