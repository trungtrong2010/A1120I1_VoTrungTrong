create database thuVien;
use thuvien;

create table theLoai(
	maTheLoai varchar(255) primary key,
    tenTheLoai varchar(255)
    );

create table sach(
	maSach int primary key,
    tenSach varchar(255),
    tacGia varchar(255),
    nhaSx varchar(255),
    gia int,
    maTheLoai varchar(255),
    foreign key (maTheLoai) references theLoai(maTheLoai)
);

create table sv(
	maThe int primary key,
    tenSv varchar(255),
    diaChi varchar(255),
    email varchar(255),
    sdt int(10),
    ngaySinh date,
    photo varchar(255)
);
create table thueSach(
	id int primary key,
    maSach int,
    foreign key (maSach) references sach(maSach),
    maThe int,
    foreign key (maThe) references sv(maThe),
    ngayMuon date,
    ngayTra date
);

