package com.example.demo.model.service;

import com.example.demo.model.entity.Product;

import java.util.List;

public interface IProductService {

    void save(Product product);

    List<Product> findAll();

    Product findById(int id);

    //    void remove(Product product);
    void remove(Product product);

    List<Product> findAllByName(String name);
}
