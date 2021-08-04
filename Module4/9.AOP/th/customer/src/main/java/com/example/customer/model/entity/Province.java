package com.example.customer.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public Province() {
    }

    public Province(int id, String name, List<Customer> customerList) {
        this.id = id;
        this.name = name;
        this.customerList = customerList;
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
