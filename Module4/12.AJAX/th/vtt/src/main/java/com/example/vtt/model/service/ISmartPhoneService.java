package com.example.vtt.model.service;

import com.example.vtt.model.entity.SmartPhone;

import java.util.List;

public interface ISmartPhoneService {

    List<SmartPhone> findAll();

    SmartPhone findById(int id);

    void save(SmartPhone smartPhone);

    void remove(SmartPhone smartPhone);
}
