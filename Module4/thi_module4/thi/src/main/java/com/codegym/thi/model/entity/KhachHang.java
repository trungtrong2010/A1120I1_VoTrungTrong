package com.codegym.thi.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phone;

    private String email;

    @OneToMany(mappedBy = "khachHang",cascade = CascadeType.ALL)
    private List<GiaoDich> giaoDichs;

    public KhachHang() {
    }

    public KhachHang(int id, String name, String phone, String email, List<GiaoDich> giaoDichs) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.giaoDichs = giaoDichs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GiaoDich> getGiaoDichs() {
        return giaoDichs;
    }

    public void setGiaoDichs(List<GiaoDich> giaoDichs) {
        this.giaoDichs = giaoDichs;
    }
}
