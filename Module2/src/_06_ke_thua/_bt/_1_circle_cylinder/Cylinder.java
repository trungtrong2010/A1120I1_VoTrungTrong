package _06_ke_thua._bt._1_circle_cylinder;

import java.util.Scanner;

public class Cylinder extends Circle {
    public double height;

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAreaCylinder() {
        return super.getArea() * 2 + super.getPerimeter() * this.height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Height= "
                + getHeight()
                + "\nArea= "
                + getAreaCylinder()
                + "\nVolume= "
                + getVolume()
                + "\n \n ----\n"
                + super.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("r= ");
        double r = scanner.nextDouble();
        System.out.println("h= ");
        double h = scanner.nextDouble();
        System.out.println("c= ");
        scanner.nextLine();
        String c = scanner.nextLine();

        Cylinder cylinder = new Cylinder(r,c,h);
        System.out.println(cylinder);
    }
}
