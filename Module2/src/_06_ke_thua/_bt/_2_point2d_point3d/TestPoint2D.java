package _06_ke_thua._bt._2_point2d_point3d;

import java.util.Scanner;

public class TestPoint2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x= ");
        int x = scanner.nextInt();
        System.out.print("y= ");
        int y = scanner.nextInt();

        Point2D point2D = new Point2D(x,y);
        System.out.println(point2D);
    }
}
