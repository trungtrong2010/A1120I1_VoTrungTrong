package _thi;

public abstract class SmartPhone {
    int id;
    String name;
    int value;
    int soLuong;
    String nhaSX;

    public SmartPhone(int id, String name, int value, int soLuong, String nhaSX) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.soLuong = soLuong;
        this.nhaSX = nhaSX;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", soLuong=" + soLuong +
                ", nhaSX='" + nhaSX + '\'' +
                '}';
    }

    public abstract void showInfor();
}
