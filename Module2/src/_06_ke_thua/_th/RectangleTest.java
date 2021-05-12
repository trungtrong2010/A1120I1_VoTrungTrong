package _06_ke_thua._th;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.0, 3.0);
        System.out.println(rectangle);

        rectangle = new Rectangle("RED", true, 3.0, 2);
        System.out.println(rectangle);

    }
}
