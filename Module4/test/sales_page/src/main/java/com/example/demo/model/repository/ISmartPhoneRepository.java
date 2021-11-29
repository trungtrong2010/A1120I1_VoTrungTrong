package com.example.demo.model.repository;

import com.example.demo.model.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Integer> {

}
