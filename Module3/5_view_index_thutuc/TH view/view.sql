create database vieww;
use vieww;

create table test(
	a int primary key,
    b int,
    c int,
    d int,
    e int,
    f int
);    

create view view_test as
select a,b,c,d
from test;
select * from view_test;

--  SỬA
create or replace view view_test as
select b,c,d
from test
where a = 2;
select * from view_test;

-- XÓA
create view a as
select a,b,c
from test;
select * from a;
drop view a;








