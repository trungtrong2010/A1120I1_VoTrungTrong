package _06_ke_thua._th;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square("red", true, 1.0);
        System.out.println(square);
    }
}
