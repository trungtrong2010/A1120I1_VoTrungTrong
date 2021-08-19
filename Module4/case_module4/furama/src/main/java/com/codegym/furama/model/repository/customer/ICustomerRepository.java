package com.codegym.furama.model.repository.customer;

import com.codegym.furama.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    Page<Customer> findAllPa(Pageable pageable);
}
