create database thutuc;
 use thutuc;
 
 create table test(
	id int,
    sdt int
 );
 
 insert into test(id,sdt)
 values(1,2),(3,4);
 
 delimiter $$
 drop procedure if exists `showInfor` $$
 create procedure showInfor()
 begin
	select * from test;
end; $$
delimiter ;

call showInfor();
 