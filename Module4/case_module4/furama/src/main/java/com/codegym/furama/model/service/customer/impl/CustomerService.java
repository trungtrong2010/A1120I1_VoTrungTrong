package com.codegym.furama.model.service.customer.impl;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.repository.customer.ICustomerRepository;
import com.codegym.furama.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

//    @Override
//    public Page<Customer> findAllPa(Pageable pageable) {
//        return this.customerRepository.findAllPa(pageable);
//    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
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
}
