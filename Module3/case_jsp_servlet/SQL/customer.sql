INSERT INTO `furamar_jsp_servlet`.`customer` (`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) VALUES ('1', '3', 'Vo Trung Trong', '1999/10/20', 1, '123', '9778823','votrungtrong@gmail.com','Quang Nam');
DELIMITER $$
CREATE PROCEDURE create_customer(
in id int,
in id_type int,
in name varchar(45),
in birthday date,
in gender bit(1),
in id_card varchar(45),
in phone varchar(45),
in email varchar(45),
in address varchar(45)
)
BEGIN
	INSERT INTO customer (customer_id, customer_type_id, customer_name, customer_birthday, customer_gender,customer_id_card, customer_phone, customer_email,customer_address)
    VALUES (id,id_type,name, birthday, gender,id_card , phone,email,address);
END $$
DELIMITER ;
call create_customer(2,2,'Nguyen Van A','2000-01-01',1,'115','09778080','nguyenvana@gmail.com','Hue');


select customer.*, customer_type.customer_type_name from customer
inner join customer_type
on customer.customer_id = customer_type.customer_type_id;

UPDATE customer SET customer_gender = 1 WHERE customer_id = 4;
UPDATE customer SET customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email= ?, customer_address = ? WHERE customer_id = ?;
CALL create_customer(63,1,'yuyu','2021/06/28',0,'878787','980989','uyuy@gmail.com','hn');
CALL create_customer(111,1,'kkkkk','2021/07/05',0,'080989','0998398','kkk@gmail.com','HN');

select customer.*, customer_type.customer_type_name from customer
left join customer_type
on customer.customer_type_id = customer_type.customer_type_id
where customer_name = ?;
select customer.*, customer_type.customer_type_name from customer 
left join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name = "";
