package com.codegym.furama.model.entity.customer;
import com.codegym.furama.validate.DateConstaint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Wrong format")
    private String name;

    @Column(columnDefinition = "DATE")
    @NotBlank(message = "Not blank")
    @DateConstaint
//    @Past(message = "ok")
//    @PastOrPresent(message = "ko")
    private String dateOfBirthday;

    @NotNull(message = "Gender not null")
    private int gender;

//    @NotBlank(message = "Wrong format ID CARD (9 or 10 number)")
    private String idCard;

    private String phone;

    @Email(message = "Wrong format email")
    @NotEmpty(message = "Not empty")
    private String email;


    @NotBlank(message = "Wrong format address")
    private String address;

    @NotNull(message = "Not null")
    @ManyToOne(targetEntity = CustomerType.class)
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(int id, String name, String dateOfBirthday, int gender, String idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (!customer.phone.matches("(090||091)+[0-9]{7}+")) {
            errors.rejectValue("phone",null,"Format error: 090/091 xxxx xxx");
        }
        if (!customer.idCard.matches("[0-9]{9,10}")) {
            errors.rejectValue("idCard",null,"Format error: 9/10 number");
        }
    }
}