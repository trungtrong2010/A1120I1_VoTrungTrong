package model;

public class Demo {
    String id;
    double dienTich;
    String trangThai;
    int tang;
    String loaiVanPhong;
    String moTaChiTiet;
    double giaChoThue;
    String ngayBatDau;
    String ngayKetThuc;

    public Demo(String id, double dienTich, String trangThai, int tang, String loaiVanPhong, String moTaChiTiet, double giaChoThue, String ngayBatDau, String ngayKetThuc) {
        this.id = id;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.moTaChiTiet = moTaChiTiet;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(String loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public double getGiaChoThue() {
        return giaChoThue;
    }

    public void setGiaChoThue(double giaChoThue) {
        this.giaChoThue = giaChoThue;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
