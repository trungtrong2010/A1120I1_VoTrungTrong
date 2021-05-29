create database thutuc_view;

create table products(
	id int primary key,
    productCode int,
	productName varchar(255),
	productPrice int,
	productAmount int,
	productDescription varchar(255),
	productStatus varchar(255)
);

-- tạo VIEW
create view test_view as
select productCode, productName, productPrice, productStatus
from products;
select * from test_view;

-- update VIEW
create or replace view test_view as
select productCode, productName
from products;
select * from test_view;

-- xóa VIEW 
drop view test_view;

-- tạo store procudure (thủ tục)
delimiter $$
create procedure showInfor()
begin
	select * from products;
end; $$
delimiter ;
call showInfor;

-- add 
delimiter $$
create procedure addproduct()
begin
	insert into products(Id,productCode,productName,productPrice,productAmount,productDescription,productStatus)
    value (5,1,"ko",12000,2,"ko","ko");
end; $$
delimiter ;
call addproduct;

-- update theo ID
delimiter $$
drop procedure if exists `update_id` $$
create procedure update_id(
	in idNew int,
	in productCodeNew int,
    in productNameNew varchar(255)
)
begin
	update products
    set productCode = productCodeNew, productName = productNameNew
    where id = idNew;
end; $$
delimiter ;
call update_id(1,999,"vovo");

-- delete theo ID
delimiter $$
create procedure delete_id(in idNew int)
begin
	delete from products
    where id = idNew;
end; $$
delimiter ;
call delete_id(5);