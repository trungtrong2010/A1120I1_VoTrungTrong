package com.example.customer.model.service.impl;

import com.example.customer.model.entity.Customer;
import com.example.customer.model.repository.CustomerRepository;
import com.example.customer.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        this.customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findByNameContaining(String name,Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }
}
