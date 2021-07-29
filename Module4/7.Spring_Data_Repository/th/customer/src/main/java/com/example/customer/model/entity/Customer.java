package com.example.customer.model.entity;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int gender;
    @Column(name = "date_of_birthday", columnDefinition = "DATE")
    private String dateOfBirthday;

    @ManyToOne
    @JoinColumn(name = "id_province", referencedColumnName = "id")
    private Province province;

    public Customer() {
    }

    public Customer(int id, String name, int gender, String dateOfBirthday, Province province) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirthday = dateOfBirthday;
        this.province = province;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
