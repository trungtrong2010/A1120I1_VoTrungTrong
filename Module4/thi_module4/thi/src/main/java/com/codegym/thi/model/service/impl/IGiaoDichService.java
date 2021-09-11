package com.codegym.thi.model.service.impl;

import com.codegym.thi.model.entity.GiaoDich;

import java.util.List;

public interface IGiaoDichService {

    List<GiaoDich> findAll();

    GiaoDich findById(int id);

    void save(GiaoDich giaoDich);

    void delete(GiaoDich giaoDich);

    List<GiaoDich> findSearch(String name,String loaidv);

}
