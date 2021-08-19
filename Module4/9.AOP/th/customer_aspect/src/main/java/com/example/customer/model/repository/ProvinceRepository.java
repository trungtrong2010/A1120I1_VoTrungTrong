package com.example.customer.model.repository;

import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province,Integer> {

}
