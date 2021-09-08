package com.codegym.furama.model.repository.service;

import com.codegym.furama.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
