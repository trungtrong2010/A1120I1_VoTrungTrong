package com.example.vtt.model.service;

import com.example.vtt.model.entity.SmartPhone;
import com.example.vtt.model.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneService implements ISmartPhoneService {

    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return this.smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(int id) {
        return this.smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SmartPhone smartPhone) {
        this.smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(SmartPhone smartPhone) {
        this.smartPhoneRepository.delete(smartPhone);
    }
}
