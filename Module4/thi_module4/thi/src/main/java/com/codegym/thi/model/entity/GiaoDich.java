package com.codegym.thi.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Service
@Entity
public class GiaoDich implements Validator {

    @Id
    private int id;

    @NotNull(message = "Trường này là bắt buộc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayGiaoDich;


    @NotBlank(message = "Trường này là bắt buộc")
    private String loaiGiaoDich;

    @NotNull(message = "Trường này là bắt buộc")
    @Min(value = 500001, message = "Mức khuyến mãi > 500.000 VNđ")
    private Double donGia;

    @NotNull(message = "Trường này là bắt buộc")
    @Min(value = 21, message = "Mức khuyến mãi > 20 m2")
    private Double dienTich;

    @ManyToOne(targetEntity = KhachHang.class)
    private KhachHang khachHang;

    public GiaoDich() {
    }

    public GiaoDich(int id, LocalDate ngayGiaoDich, String loaiGiaoDich, Double donGia, Double dienTich, KhachHang khachHang) {
        this.id = id;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.khachHang = khachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        GiaoDich giaoDich = (GiaoDich) target;
        if (giaoDich.getDonGia() == giaoDich.getDienTich()) {
            errors.rejectValue("donGia",null,"không được bằng nhau");
        }
    }
}
