package com.codegym.vtt.model.service.impl;

import com.codegym.vtt.model.entity.Product;
import com.codegym.vtt.model.repository.IProductRepository;
import com.codegym.vtt.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
//    public Page<Product> findAll(Pageable pageable) {
//        return this.productRepository.findAll(pageable);
//    }
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }


    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Product product) {
        this.productRepository.delete(product);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

//    @Override
//    public Page<Product> findByNameContaining(String name, Pageable pageable) {
//        return this.productRepository.findByNameContaining(name, pageable);
//    }
}
