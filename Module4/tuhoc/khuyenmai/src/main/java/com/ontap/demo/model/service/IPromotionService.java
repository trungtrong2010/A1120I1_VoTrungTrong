package com.ontap.demo.model.service;

import com.ontap.demo.model.entity.Promotion;

import java.util.List;

public interface IPromotionService {
    List<Promotion> findAll();

    Promotion findById(int id);

    void save(Promotion promotion);

    void delete(Promotion promotion);

    List<Promotion> search(String startDateSearch, String endDateSearch, String detailSearch);
}
