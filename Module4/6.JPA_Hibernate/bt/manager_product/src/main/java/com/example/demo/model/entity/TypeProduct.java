package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "type")
public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_type")
    private String nameType;

    @OneToMany(mappedBy = "typeProduct") //mapping với thuộc tính khai báo bên @ManyToOne
    private List<Product> productList;

    public TypeProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
