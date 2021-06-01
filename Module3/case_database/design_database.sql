create table vitri(
	idViTri int primary key,
    tenViTri varchar(45)
);
create table trinhdo(
	idTrinhDo int primary key,
    trinhDo varchar(45)
);
create table bophan(
	idBoPhan int primary key,
    tenBoPhan varchar(45)
);
create table nhanvien(
	idNhanVien int primary key,
    hoTen varchar(45),
    idViTri int,
    foreign key (idViTri) references vitri(idViTri),
    idTrinhDo int,
    foreign key (idTrinhDo) references trinhdo(idTrinhDo),
    idBoPhan int,
    foreign key (idBoPhan) references bophan(idBoPhan),
    ngaySinh date,
    soCMND int,
    luong int,
    sdt varchar(10),
    email varchar(45),
    diaChi varchar(45)
);

create table loaikhach(
	idLoaiKhach int primary key,
    tenLoaiKhach varchar(45)
);
create table khachhang(
	idKhachHang int primary key,
    idLoaiKhach int,
    foreign key (idLoaiKhach) references loaikhach(idLoaiKhach),
    hoTen varchar(45),
    ngaySinh date,
    soCMND int,
    sdt varchar(10),
    email varchar(45),
    diaChi varchar(45)
);

create table kieuthue(
	idKieuThue int primary key,
    tenKieuThue varchar(45),
    gia int
);
create table loaidichvu(
	idLoaiDichVu int primary key,
    tenLoaiDichVu varchar(45)
);
create table dichvu(
	idDichVu int primary key,
    tenDichVu varchar(45),
    dienTich int,
    soTang int,
    soNguoiToiDa int,
    chiPhiThue int,
    idKieuThue int,
    foreign key (idKieuThue) references kieuthue(idKieuThue),
    idLoaiDichVu int,
    foreign key (idLoaiDichVu) references loaidichvu(idLoaiDichVu),
    trangThai varchar(45)
);

create table hopdong(
	idHopDong int primary key,
    idNhanVien int,
    foreign key (idNhanVien) references nhanvien(idNhanVien),
    idKhachHang int,
    foreign key (idKhachHang) references khachhang(idKhachHang),
    idDichVu int,
    foreign key (idDichVu) references dichvu(idDichVu),
    ngayLamHopDong date,
    ngayKetThuc date,
    tienDatCoc int,
    tongTien int
);
create table dichvudikem(
	idDichVuDiKem int primary key,
    tenDichVuDiKem varchar(45),
    gia int,
    donVi int,
    trangThaiKhaDung varchar(45)
);
create table hopdongchitiet(
	idHopDongChiTiet int primary key,
    idHoloaikhachpDong int,
    foreign key (idHopDong) references hopdong(idHopDong),
    idDichVuDiKem int,
    foreign key (idDichVuDiKem) references dichvudikem(idDichVuDiKem),
    soLuong int
);