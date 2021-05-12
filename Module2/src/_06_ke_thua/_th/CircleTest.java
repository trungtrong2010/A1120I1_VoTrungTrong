package _06_ke_thua._th;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2);
        System.out.println(circle);

        circle = new Circle("red", false, 3.0);
        System.out.println(circle);

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());

    }
}
