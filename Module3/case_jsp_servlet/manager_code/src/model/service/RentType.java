package model.service;

public class RentType {
    private int id;
    private String name;

    public RentType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RentType() {

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
}
