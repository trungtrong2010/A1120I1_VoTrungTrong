-- 1. Thêm mới thông tin
-- Đã thêm trực tiếp bằng cách điền vào form

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt 
-- đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from nhanvien
where hoTen like ("H%") or hoTen like("K%") or hoTen like ("T%")
having length(hoTen) <= 15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from nhanvien
where timestampdiff(day,ngaySinh,CURDATE())/365 >=18 and timestampdiff(day,ngaySinh,CURDATE())/365 <= 50
and diaChi = "Đà Nẵng" or diaChi = "Quảng Trị";

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng 
-- dần theo loaikhachloaikhachsố lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.