package com.example.vtt.model.repository;

import com.example.vtt.model.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Integer> {
}
