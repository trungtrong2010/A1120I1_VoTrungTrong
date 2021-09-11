package com.codegym.test.model.service;

import com.codegym.test.model.entity.KhuyenMai;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IKhuyenMaiService {

    List<KhuyenMai> findAll();

    KhuyenMai findById(int id);

    void save(KhuyenMai khuyenMai);

    void delete(KhuyenMai khuyenMai);

    List<KhuyenMai> find3Truong(String discount, String startDate, String endDate);
}
