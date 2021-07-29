package com.example.customer.model.service;

import com.example.customer.model.entity.Province;
import org.springframework.data.domain.Page;

public interface IProvinceService {
    Iterable<Province> findAll();

    Province findById(int id);

    void save(Province province);

    void remove(int id);
}
