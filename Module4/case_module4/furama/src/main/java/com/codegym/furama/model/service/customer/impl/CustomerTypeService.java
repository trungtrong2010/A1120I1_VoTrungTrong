package com.codegym.furama.model.service.customer.impl;

import com.codegym.furama.model.entity.customer.CustomerType;
import com.codegym.furama.model.repository.customer.ICustomerTypeRepository;
import com.codegym.furama.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }
}
