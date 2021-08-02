package com.example.demo.model.service.impl;

import com.example.demo.model.entity.TypeProduct;
import com.example.demo.model.repository.ITypeProductRepository;
import com.example.demo.model.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {

    @Autowired
    private ITypeProductRepository iTypeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return iTypeProductRepository.findAll();
    }
}
