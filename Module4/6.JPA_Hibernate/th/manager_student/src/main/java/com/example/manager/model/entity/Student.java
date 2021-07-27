package com.example.manager.model.entity;


import javax.persistence.*;

@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(columnDefinition = "DATE")
    private String dateOfBirthday;

    private int gender;

    private String class_student;

    public Student() {
    }

    public Student(int id, String name, String dateOfBirthday, int gender, String class_student) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
        this.class_student = class_student;
    }

    public String getClass_student() {
        return class_student;
    }

    public void setClass_student(String class_student) {
        this.class_student = class_student;
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
}
