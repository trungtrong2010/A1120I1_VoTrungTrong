package _x_case_study._task1._task1;

public class Room extends Services {

    private String dvFree;

    public Room(String nameServices, int area, int money, int peopleMax,
                String rentalType, String id, String dvPlus, String dvFree) {
        super(nameServices, area, money, peopleMax, rentalType, id, dvPlus);
        this.dvFree = dvFree;
    }

    public Room() {
    }

    public String getDvFree() {
        return dvFree;
    }

    public void setDvFree(String dvFree) {
        this.dvFree = dvFree;
    }

    @Override
    public String toString() {
        return "\n" + "Room{" +
                "nameServices='" + super.getNameServices() + '\'' +
                ", area=" + super.getArea() +
                ", money=" + super.getMoney() +
                ", peopleMax=" + super.getPeopleMax() +
                ", rentalType='" + super.getRentalType() + '\'' +
                ", id='" + super.getId() + '\'' +
                ", dvPlus='" + super.getDvPlus() + '\'' +
                "dvFree='" + dvFree + '\'' +
                '}';
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
