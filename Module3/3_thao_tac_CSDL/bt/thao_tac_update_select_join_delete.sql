select tenTheLoai from sach
inner join theloai
on theloai.maTheLoai = sach.maTheLoai;

select * from sach
inner join theloai
on theloai.maTheLoai = sach.maTheLoai;

select tenTheLoai from sach
inner join theloai
on theloai.maTheLoai = sach.maTheLoai
group by tenTheLoai;

select tenTheLoai,count(tenTheLoai) from sach
inner join theloai
on theloai.maTheLoai = sach.maTheLoai;

select tenTheLoai,count(tenTheLoai) from sach
inner join theloai
on theloai.maTheLoai = sach.maTheLoai
group by tenTheLoai;

select * from thuesach
inner join sach
on thuesach.maSach = sach.maSach
inner join theloai
on sach.maTheLoai = theloai.maTheLoai
inner join sv
on thuesach.maThe = sv.maThe;

select count(maThe) as đếm from sv;

select * from theloai;

select * from sach;

select * from sv;

select * from thuesach;

update sv 
set tenSV = "Võ"
where maThe = 111;