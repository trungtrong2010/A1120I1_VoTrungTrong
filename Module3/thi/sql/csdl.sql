create database csdl_thi;
create table category(
	id int primary key,
    category varchar(255)
);
create table product(
	id int primary key,
	name varchar(255),
    count double,
    amount int,
    color  varchar(45) ,
    described varchar(255),
    id_category int,
    foreign key (id_category) references category(id)
);