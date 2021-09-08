package com.codegym.furama.model.repository.service;

import com.codegym.furama.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IServiceRepository extends JpaRepository<Service,Integer> {
    @Query(value = "select s from Service s where (s.name like %:name%) and (:idRentType is null or s.rentType.id = :idRentType) and (:idServiceType is null or s.serviceType.id = :idServiceType)")
    Page<Service> findAllSearch3Var(String name, Optional<Integer> idRentType, Optional<Integer> idServiceType, Pageable pageable);
}
