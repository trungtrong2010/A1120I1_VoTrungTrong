package com.example.user.model.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "user")
public class User {
    @Id
//    @NotEmpty(message = "not found")
    @NotBlank(message = "not found")
//    @NotNull(message = "Not found")
//    @Size(min = 2, max = 30, message = "1<x<31")
    private String name;

//    @NotBlank(message = "not found") error
//    @NotEmpty(message = "not found") error
//    @NotNull(message = "not found") không hiểu thị lỗi "not found"
    @Min(value = 18,message = "sai rồi kìa")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
