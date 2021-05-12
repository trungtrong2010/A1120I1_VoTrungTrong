package _06_ke_thua._bt._2_point2d_point3d;

import java.util.Scanner;

public class TestPoint3D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x= ");
        int x = scanner.nextInt();
        System.out.print("y= ");
        int y = scanner.nextInt();
        System.out.print("z= ");
        int z = scanner.nextInt();

        Point3D point3D = new Point3D(x,y,z);
        System.out.println(point3D);
    }
}
