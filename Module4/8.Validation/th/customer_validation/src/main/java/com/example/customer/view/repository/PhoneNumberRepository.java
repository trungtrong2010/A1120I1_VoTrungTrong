package com.example.customer.view.repository;

import com.example.customer.view.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, String> {

}
