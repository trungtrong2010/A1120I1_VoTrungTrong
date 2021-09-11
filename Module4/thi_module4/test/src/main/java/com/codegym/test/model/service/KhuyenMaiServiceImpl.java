package com.codegym.test.model.service;

import com.codegym.test.model.entity.KhuyenMai;
import com.codegym.test.model.repository.IKhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiServiceImpl implements IKhuyenMaiService {

    @Autowired
    private IKhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> findAll() {
        return this.khuyenMaiRepository.findAll();
    }

    @Override
    public KhuyenMai findById(int id) {
        return this.khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        this.khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(KhuyenMai khuyenMai) {
        this.khuyenMaiRepository.delete(khuyenMai);
    }

    @Override
    public List<KhuyenMai> find3Truong(String discount, String startDate, String endDate) {
        return this.khuyenMaiRepository.find3Truong(discount, startDate, endDate);
    }


}
