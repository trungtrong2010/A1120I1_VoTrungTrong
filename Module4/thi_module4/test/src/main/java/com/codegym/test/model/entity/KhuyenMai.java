package com.codegym.test.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class KhuyenMai implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Trường này là bắt buộc")
    private String title;

    @NotNull(message = "Trường này là bắt buộc")
    @FutureOrPresent(message = "Ngày phải lớn hơn hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "Trường này là bắt buộc")
    @FutureOrPresent(message = "Ngày phải lớn hơn hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull(message = "Trường này là bắt buộc")
    @Min(value = 10000, message = "Mức khuyến mãi > 10.000 VNđ")
    private Double discountRate;

    @NotBlank(message = "Trường này là bắt buộc")
    private String detail;

    public KhuyenMai() {
    }

    public KhuyenMai(int id, @NotBlank(message = "Trường này là bắt buộc") String title, LocalDate startDate, LocalDate endDate, @NotBlank(message = "Trường này là bắt buộc") Double discountRate, @NotBlank(message = "Trường này là bắt buộc") String detail) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountRate = discountRate;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        KhuyenMai khuyenMai = (KhuyenMai) target;
        if (khuyenMai.startDate.isBefore(khuyenMai.endDate)) {
            errors.rejectValue("startDate",null,"Ngày kết thúc phải lớn hơn ngày bắt đầu");
        }
    }
}
