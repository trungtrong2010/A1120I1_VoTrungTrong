create database bt4;

use bt4;

create table infor(
	id int primary key,
    ten varchar(255),
    tuoi int,
    khoaHoc varchar(255),
    soTien int
);

select * from infor
where ten="Huong";

select sum(soTien) as Tong_tien_cua_Huong from infor
where ten="huong";

select * from infor
group by ten;
