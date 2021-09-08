package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);

    Page<Customer> findAllByNameContainingAndGenderAndCustomerType(String name, String gender, String idType, Pageable pageable);
}
