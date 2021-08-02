package com.example.customer.model.service;

import com.example.customer.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);

    Page<Customer> findByNameContaining(String name,Pageable pageable);

    Page<Customer> findAllByProvinceId(int id, Pageable pageable);

    Page<Customer> findAllByProvinceIdAndNameContaining(int id, String name, Pageable pageable);
}
