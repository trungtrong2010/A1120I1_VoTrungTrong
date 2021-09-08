package com.codegym.furama.model.repository.customer;

import com.codegym.furama.model.entity.customer.Customer;
import com.codegym.furama.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value="select * from customer where name like %?1% and gender like %?2% and customer_type_id like %?3%" , nativeQuery =true)
    Page<Customer> findAllByNameContainingAndGenderAndCustomerType(String name, String gender, String idType ,Pageable pageable);

}
