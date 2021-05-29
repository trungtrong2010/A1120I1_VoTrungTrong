create database truyenthamso_vao_store_procedure;
use truyenthamso_vao_store_procedure;
create table test_in(
	id int primary key,
    sdt int
);
delimiter $$
drop procedure if exists `findId` $$
create procedure findId(in temp int)
begin
	select * from test_in
    where id = temp;
end; $$
delimiter ;
call findId();

create table test_out(
	id int,
    a int
);
insert into test_out(id,a)
values (2,43),(4,3424),(1,4343),(6,432),(4,2332);
delimiter $$
create procedure findOut(
	in in_id int,
    out total int
)
begin
	select count(id)
    into total
    from test_out
    where id = in_id;
end; $$
delimiter ;

call findOut(6,@total);
select @total;

create table in_out(
	id int primary key,
    a int
);

delimiter $$
create procedure setValue(
	inout tong int,
    in idp int
)
begin
	set tong = tong + idp;
end; $$
delimiter ;

set @tong=1;
call setValue(@tong,1);
select @tong;
    