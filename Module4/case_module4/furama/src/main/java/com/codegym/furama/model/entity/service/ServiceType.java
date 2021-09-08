package com.codegym.furama.model.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {

    @Id
    private Integer id;

    @Column(length = 45)
    private String name;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<Service> services;

    public ServiceType() {
    }

    public ServiceType(Integer id, String name, List<Service> services) {
        this.id = id;
        this.name = name;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
