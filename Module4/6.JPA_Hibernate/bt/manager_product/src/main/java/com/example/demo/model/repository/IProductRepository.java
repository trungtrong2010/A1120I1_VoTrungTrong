package com.example.demo.model.repository;

import com.example.demo.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT product.*, type.name_type FROM product\n" +
            "LEFT JOIN type ON product.type_id= type.id\n" +
            "where product.name like %1%;", nativeQuery = true)
    List<Product> findAllByName(String name);
}
