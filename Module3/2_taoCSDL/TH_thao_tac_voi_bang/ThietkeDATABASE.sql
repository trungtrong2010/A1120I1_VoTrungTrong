create database khoachinh_khoangoai;

use khoachinh_khoangoai;

create table customer(
	customer_number int(20) primary key not null,
    fullname varchar(255) not null,
    address varchar(255),
    email varchar(255),
    phone int(10) not null
    );
    
 create table accounts(
	account_number int(20) primary key not null,
    account_type varchar(255),
    days date,
    balance int,
    customer_number int(20),
    foreign key(customer_number) references customer(customer_number)
    );
    
create table transantions(
	tran_number int(20) primary key not null,
    account_number int(20)not null,
    tran_date date,
    amounts int(20),
    descriptions varchar(255),
    foreign key(account_number) references accounts(account_number)
    );
    
insert into customer(customer_number,fullname,address,email,phone)
values(1243,"trong","Dai Bang","aa",091922939);

select * from customer;

insert into accounts(account_number,account_type,days,balance,customer_number)
values(321321,"wqe","2020-10-20",2000000000,1243);

select * from accounts;

insert into transantions(tran_number,account_number,tran_date,amounts,descriptions)
values(555,321321,"2021-05-20",1000000,"ck");

select * from transantions;
    
    
select * from customer
inner join accounts
on customer.customer_number = accounts.customer_number
inner join transantions
on transantions.account_number = accounts.account_number;
