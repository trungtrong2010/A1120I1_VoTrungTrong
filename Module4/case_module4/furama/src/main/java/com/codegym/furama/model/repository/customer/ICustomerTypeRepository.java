package com.codegym.furama.model.repository.customer;

import com.codegym.furama.model.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
