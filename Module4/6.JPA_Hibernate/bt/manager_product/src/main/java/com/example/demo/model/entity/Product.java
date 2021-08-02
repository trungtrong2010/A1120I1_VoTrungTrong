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

    private int gender;

    private String address;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeProduct typeProduct;

    public Product() {
    }

    public Product(int id, String name, String dateOfBirthday, int gender, String address, TypeProduct typeProduct) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
        this.address = address;
        this.typeProduct = typeProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
