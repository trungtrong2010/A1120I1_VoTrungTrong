package com.codegym.thi.model.repository;

import com.codegym.thi.model.entity.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGiaoDichRepository extends JpaRepository<GiaoDich, Integer> {
    @Query(value = "select g from GiaoDich g where (g.khachHang.name like %:name%) and (:loaidv is null or g.loaiGiaoDich =:loaidv)")
    List<GiaoDich> findSearch(String name,String loaidv);
}
