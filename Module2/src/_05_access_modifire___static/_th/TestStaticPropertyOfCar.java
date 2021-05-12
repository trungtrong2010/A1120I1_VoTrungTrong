package _05_access_modifire___static._th;

public class TestStaticPropertyOfCar {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3", "yamaha");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Mazda 6", "honda");
        System.out.println(Car.numberOfCars);
    }
}
