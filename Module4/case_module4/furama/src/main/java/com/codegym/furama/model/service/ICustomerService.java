package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);

    Page<Customer> findAllByNameContainingAndGenderAndCustomerType(String name, String gender,String idType, Pageable pageable);
}
