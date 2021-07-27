package com.example.demo.model.entity;

import javax.persistence.*;

@Entity(name = "product")
public class Product {

    @Id //Khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự độgn tăng
    private int id;

    @Column(name = "name") // để chỉ đến cái cột nào
    private String name;

    @Column(name = "date_of_birthday", columnDefinition = "DATE") // columnDefinition: khai báo lại kiểu dữ liệu trong DB
    private String dateOfBirthday;


}
