package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    Page<Service> findAllSearch3Var(String name, Optional<Integer> idRentType, Optional<Integer> idServiceType, Pageable pageable);

    Service findById(Integer id);

    void save(Service service);

    void delete(Service service);
}
