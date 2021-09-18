package com.codegym.thi.model.service.impl;

import com.codegym.thi.model.entity.GiaoDich;
import com.codegym.thi.model.repository.IGiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichServiceImpl implements IGiaoDichService{

    @Autowired
    private IGiaoDichRepository giaoDichRepository;

    @Override
    public List<GiaoDich> findAll() {
        return this.giaoDichRepository.findAll();
    }

    @Override
    public GiaoDich findById(int id) {
        return this.giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public void save(GiaoDich giaoDich) {
        this.giaoDichRepository.save(giaoDich);
    }

    @Override
    public void delete(GiaoDich giaoDich) {
        this.giaoDichRepository.delete(giaoDich);
    }

    @Override
    public List<GiaoDich> findSearch(String name, String loaidv) {
        if (loaidv.equals("")) {
            loaidv = null;
        }
        return this.giaoDichRepository.findSearch(name, loaidv);
    }
}
