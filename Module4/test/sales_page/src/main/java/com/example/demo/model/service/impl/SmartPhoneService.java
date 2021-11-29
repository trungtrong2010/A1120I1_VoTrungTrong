package com.example.demo.model.service.impl;

import com.example.demo.model.entity.SmartPhone;
import com.example.demo.model.repository.ISmartPhoneRepository;
import com.example.demo.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhoneService {

    @Autowired
    private ISmartPhoneRepository repository;

    @Override
    public List<SmartPhone> findAll() {
        return repository.findAll();
    }

    @Override
    public SmartPhone findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(SmartPhone smartPhone) {
        repository.delete(smartPhone);
    }

    @Override
    public void save(SmartPhone smartPhone) {
        repository.save(smartPhone);
    }
}
