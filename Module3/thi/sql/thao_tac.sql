SELECT * FROM csdl_thi.product;

SELECT product.*, category.category FROM product
LEFT JOIN category ON product.id_category = category.id
where name like concat('%',?,'%');
INSERT INTO `csdl_thi`.`product` (`id`, `name`, `count`, `amount`, `color`, `described`, `id_category`) VALUES (?,?,?,?,?,?,?);

UPDATE `csdl_thi`.`product` SET `name` = ?, `count` = ?, `amount` = ?, `color` = ?, `described` = ?, `id_category` = ? WHERE (`id` = ?);

delete from product where id = ?;