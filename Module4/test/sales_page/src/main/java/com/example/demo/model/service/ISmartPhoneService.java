package com.example.demo.model.service;

import com.example.demo.model.entity.SmartPhone;

import java.util.List;

public interface ISmartPhoneService {

    List<SmartPhone> findAll();

    SmartPhone findById(int id);

    void delete(SmartPhone smartPhone);

    void save(SmartPhone smartPhone);

}
