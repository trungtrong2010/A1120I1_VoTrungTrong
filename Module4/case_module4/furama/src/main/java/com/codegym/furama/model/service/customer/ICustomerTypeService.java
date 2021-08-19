package com.codegym.furama.model.service.customer;

import com.codegym.furama.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
