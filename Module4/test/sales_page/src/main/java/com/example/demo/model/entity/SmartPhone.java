package com.example.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class SmartPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Not blank")
    private String name;

    @NotNull(message = "Not null")
    private Double pricce;

    public SmartPhone() {
    }

    public SmartPhone(Integer id, @NotBlank(message = "Not blank") String name, @NotNull(message = "Not null") Double pricce) {
        this.id = id;
        this.name = name;
        this.pricce = pricce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPricce() {
        return pricce;
    }

    public void setPricce(Double pricce) {
        this.pricce = pricce;
    }



}
