package com.example.customer.model.repository;

import com.example.customer.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //    @Query(value = "select * from customer where customer.name like %?1% ", nativeQuery = true)
//    Page<Customer> findAllByNameLike(String name, Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    @Query(value="SELECT * FROM customer WHERE province_id = :id"
            , nativeQuery=true)
    Page<Customer> findAllByProvinceId(@Param("id") int id, Pageable pageable);

    @Query(value = "SELECT * FROM customer JOIN province WHERE customer.province_id = province.id AND province.id = ?1 AND customer.name like %?2%"
            , nativeQuery = true)
    Page<Customer> findAllByProvinceIdAndNameContaining(int id, String name, Pageable pageable);
}