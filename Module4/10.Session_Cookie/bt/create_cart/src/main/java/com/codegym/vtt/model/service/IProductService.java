package com.codegym.vtt.model.service;

import com.codegym.vtt.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
//    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    Product findById(int id);

    void delete(Product product);

    void save(Product product);

//    Page<Product> findByNameContaining(String name, Pageable pageable);
}
