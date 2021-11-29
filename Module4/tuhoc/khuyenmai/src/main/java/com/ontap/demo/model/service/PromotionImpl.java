package com.ontap.demo.model.service;

import com.ontap.demo.model.entity.Promotion;
import com.ontap.demo.model.repository.IPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionImpl implements IPromotionService {

    @Autowired
    private IPromotionRepository promotionRepository;

    @Override
    public List<Promotion> findAll() {
        return this.promotionRepository.findAll();
    }

    @Override
    public Promotion findById(int id) {
        return this.promotionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Promotion promotion) {
        this.promotionRepository.save(promotion);
    }

    @Override
    public void delete(Promotion promotion) {
        this.promotionRepository.delete(promotion);
    }

    @Override
    public List<Promotion> search(String startDateSearch, String endDateSearch, String detailSearch) {
        if (startDateSearch.equals("") && endDateSearch.equals("")) return this.promotionRepository.findAll();
        else return this.promotionRepository.search(startDateSearch, endDateSearch, detailSearch);
    }
}
