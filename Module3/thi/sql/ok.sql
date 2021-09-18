CREATE DATABASE bachkhoa_dn;

USE bachkhoa_dn;

CREATE TABLE class(
	id INT PRIMARY KEY NOT NULL,
    name VARCHAR(10)
);

CREATE TABLE student(
	id INT PRIMARY KEY NOT NULL,
    name VARCHAR(45) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    date_of_birth DATE NOT NULL,
	id_class INT NOT NULL,
    FOREIGN KEY (id_class) REFERENCES class(id)
);

INSERT INTO `bachkhoa_dn`.`class` (`id`, `name`) VALUES ('1', '17DT1');
INSERT INTO `bachkhoa_dn`.`class` (`id`, `name`) VALUES ('2', '17DT2');
INSERT INTO `bachkhoa_dn`.`class` (`id`, `name`) VALUES ('3', '17DT3');
INSERT INTO `bachkhoa_dn`.`class` (`id`, `name`) VALUES ('4', '17DTCLC');

INSERT INTO `bachkhoa_dn`.`student` (`id`, `name`, `gender`, `date_of_birth`, `id_class`) VALUES ('106170213', 'Võ Trung Trọng ', 'Nam', '1999/10/20', '3');
INSERT INTO `bachkhoa_dn`.`student` (`id`, `name`, `gender`, `date_of_birth`, `id_class`) VALUES ('106170216', 'Trần Văn Ý', 'Nam', '1999/01/10', '3');
INSERT INTO `bachkhoa_dn`.`student` (`id`, `name`, `gender`, `date_of_birth`, `id_class`) VALUES ('106170201', 'Nguyễn Thị An', 'Nữ', '1999/02/03', '1');
INSERT INTO `bachkhoa_dn`.`student` (`id`, `name`, `gender`, `date_of_birth`, `id_class`) VALUES ('106170222', 'Trần Thị Xuân', 'Nữ', '1999/12/12', '4');

UPDATE student SET name = 'Trần Thị Hoa' WHERE (id = '106170222');

SELECT student.*, class.name FROM student
LEFT JOIN class ON student.id_class = class.id;

