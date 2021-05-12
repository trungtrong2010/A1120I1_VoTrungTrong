package _05_access_modifire___static._bt;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(1.0);
        System.out.println("r= " + circle.getRadius());
        System.out.println("S=" + circle.getArea());
    }
}
