package com.codegym.vtt.model.repository;

import com.codegym.vtt.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    @Query(value = "select * from product", nativeQuery = true)
//    Page<Product> findAll(Pageable pageable);
//
//    Page<Product> findByNameContaining(String name, Pageable pageable);
}
