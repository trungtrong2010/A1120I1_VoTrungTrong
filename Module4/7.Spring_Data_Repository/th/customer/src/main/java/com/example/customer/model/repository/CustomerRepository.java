package com.example.customer.model.repository;

import com.example.customer.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //    @Query(value = "select * from customer where customer.name like %?1% ", nativeQuery = true)
//    Page<Customer> findAllByNameLike(String name, Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}