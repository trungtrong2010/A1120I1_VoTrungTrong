package com.codegym.furama.model.service.customer;

import com.codegym.furama.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
