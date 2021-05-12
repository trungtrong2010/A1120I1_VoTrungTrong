package _ontap_oop_java._1_xe;

public class Vehicle {
    private double value;
    private double capacity;
    double tax;

    public Vehicle(double value, double capacity) {
        this.value = value;
        this.capacity = capacity;
    }

    public Vehicle() {
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double taxVehicle() {
        if (this.capacity <= 100) {
            tax = this.value * 1 / 100;
        } else if (this.capacity >= 300) {
            tax = this.value * 5 / 100;
        } else tax = this.value * 3 / 100;
        return tax;
    }

    @Override
    public String toString() {
        return "**Value=" + value + ", capacity=" + capacity + ",tax =" + taxVehicle() + "\n";
    }

}
