-- tao database
create database thao_tac_csdl;

-- tro? vao database
use thao_tac_csdl;

-- tao bang 3 column & 1 khoa_chinh
create table test
(	a int(10) not null auto_increment,
	b varchar(255) not null,
	c date default '2020/01/01',
	constraint khoa_chinh primary key (a)
    );
-- delete table test
drop table test;


create table ads
( 	id int(10) not null auto_increment,
	hoten varchar(255) not null,
	birthday date default '2020/01/01',
	constraint ok_khoa_chinh primary key (id)
);

-- fix + add 2 column ho & ten vao culum hoten
alter table ads
	add ho varchar (10) not null
		after hoten,
	add ten varchar (20) not null
		after hoten;

-- fix mo ta of 1 column 
alter table ads
	modify ho varchar (20) null;
    
-- delete 1 column 
alter table ads
	drop column ho;
    
-- fix name column
alter table ads
	change column ten name varchar (25) not null;
    
-- rename table
alter table taocsdl
	rename to ok;
    