package com.codegym.furama.model.service.customer;

import com.codegym.furama.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
//    Page<Customer> findAllPa(Pageable pageable);

    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(Customer customer);
}
