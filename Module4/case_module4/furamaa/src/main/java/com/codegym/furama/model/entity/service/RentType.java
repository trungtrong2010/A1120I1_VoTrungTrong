package com.codegym.furama.model.entity.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType implements Validator {

    @Id
    private Integer id;

    @Column(length = 45)
    private String name;

    private Double cost;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private List<Service> services;

    public RentType() {
    }

    public RentType(Integer id, String name, Double cost, List<Service> services) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.services = services;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RentType rentType = (RentType) target;
//        if ()
    }
}
