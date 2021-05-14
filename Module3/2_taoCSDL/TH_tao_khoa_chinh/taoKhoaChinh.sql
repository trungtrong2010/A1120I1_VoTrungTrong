create database taoKhoaChinh;
use taokhoachinh;

-- tao khoa chinh ngay tai time khoi tao.
create table user(
	id int (10) auto_increment primary key,
    name varchar(255),
    password varchar(255),
    email varchar(255)
);

-- tao khoa chinh sau khi khai bao
create table ok(
	a int (10),
    b int (20),
    primary key(a)
);

-- add khoa chinh
create table ko(
	a int (10),
    b int (20)
);
alter table ko
	add primary key(a);