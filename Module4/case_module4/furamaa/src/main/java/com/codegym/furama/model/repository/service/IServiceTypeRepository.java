package com.codegym.furama.model.repository.service;

import com.codegym.furama.model.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
