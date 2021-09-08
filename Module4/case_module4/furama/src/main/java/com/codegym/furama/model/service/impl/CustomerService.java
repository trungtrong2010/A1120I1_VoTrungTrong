package com.codegym.furama.model.service.impl;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.repository.customer.ICustomerRepository;
import com.codegym.furama.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllByNameContainingAndGenderAndCustomerType(String name, String gender, String idType, Pageable pageable) {

        if (gender.equals("-1")) {
            gender = "";
        }
        if (idType.equals("-1")) {
            idType = "";
        }

        return this.customerRepository.findAllByNameContainingAndGenderAndCustomerType(name, gender, idType, pageable);
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
