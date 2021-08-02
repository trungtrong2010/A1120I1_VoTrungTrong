package model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private int gender;
    @Column(name = "hbpd", columnDefinition = "DATE")
    private String hbpd;
    @Column(name = "type")
    private String type;

    public Customer() {
    }

    public Customer(String name, int gender, String type) {
        this.name = name;
        this.gender = gender;
        this.type = type;
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

    public String getHbpd() {
        return hbpd;
    }

    public void setHbpd(String hbpd) {
        this.hbpd = hbpd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
