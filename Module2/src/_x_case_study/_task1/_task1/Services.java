package _x_case_study._task1._task1;

public abstract class Services {

    private String nameServices;
    private int area;
    private int money;
    private int peopleMax;
    private String rentalType;
    private String id;
    private String dvPlus;

    public Services(String nameServices, int area, int money,
                    int peopleMax, String rentalType, String id, String dvPlus) {
        this.nameServices = nameServices;
        this.area = area;
        this.money = money;
        this.peopleMax = peopleMax;
        this.rentalType = rentalType;
        this.id = id;
        this.dvPlus = dvPlus;
    }

    public Services() {
    }

    public String getNameServices() {
        return this.nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPeopleMax() {
        return peopleMax;
    }

    public void setPeopleMax(int peopleMax) {
        this.peopleMax = peopleMax;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDvPlus() {
        return dvPlus;
    }

    public void setDvPlus(String dvPlus) {
        this.dvPlus = dvPlus;
    }

    @Override
    public String toString() {
        return "Services{" +
                "nameServices='" + nameServices + '\'' +
                ", area=" + area +
                ", money=" + money +
                ", peopleMax=" + peopleMax +
                ", rentalType='" + rentalType + '\'' +
                ", id='" + id + '\'' +
                ", dvPlus='" + dvPlus + '\'' +
                '}';
    }

    public abstract void showInfor();
}
