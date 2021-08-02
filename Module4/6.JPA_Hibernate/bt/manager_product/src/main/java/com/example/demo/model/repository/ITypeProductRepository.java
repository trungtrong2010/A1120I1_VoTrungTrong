package com.example.demo.model.repository;

import com.example.demo.model.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeProductRepository extends JpaRepository<TypeProduct,Integer> {
}
