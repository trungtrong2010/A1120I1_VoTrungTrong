create database user;
use user;
create table  users(
	id int primary key auto_increment,
    name varchar(120) not null,
    email varchar(120) not null,
    country varchar(120)
);