package com.codegym.thi.model.repository;

import com.codegym.thi.model.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKhachHangRepository extends JpaRepository<KhachHang,Integer> {
}
