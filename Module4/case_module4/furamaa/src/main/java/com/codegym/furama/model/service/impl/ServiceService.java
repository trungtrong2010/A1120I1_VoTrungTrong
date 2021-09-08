package com.codegym.furama.model.service.impl;

import com.codegym.furama.model.entity.service.Service;
import com.codegym.furama.model.repository.service.IServiceRepository;
import com.codegym.furama.model.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Service> findAllSearch3Var(String name, Optional<Integer> idRentType, Optional<Integer> idServiceType, Pageable pageable) {
        return this.serviceRepository.findAllSearch3Var(name, idRentType, idServiceType, pageable);
    }

    @Override
    public Service findById(Integer id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public void delete(Service service) {
        this.serviceRepository.delete(service);
    }
}
