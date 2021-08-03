package com.example.user.model.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Not found")
    private String name;
    private String phoneNumber;
    @Min(value = 18, message = "Over 18 years")
    private int age;
    @NotEmpty(message = "Not found")
    @Email(message = "Wrong email format")
    private String email;

    @ManyToOne(targetEntity = TypeUser.class)
    @NotNull(message = "Not null")
    private TypeUser typeUser;

    public User() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.phoneNumber.matches("(03||05||07||08||09)+[0-9]{8}+")) {
            errors.rejectValue("phoneNumber", null, "Format error: 03,05,07,08,09 + 8_numbers");
        }
    }
}
