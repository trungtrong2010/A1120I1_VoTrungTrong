package _04_class_object._th;

import java.util.Scanner;

public class Rectangle {
    double wight, height;

    public Rectangle() {
    }

    public Rectangle(double wight, double height) {
        this.wight = wight;
        this.height = height;
    }

    public double area() {
        return this.wight * this.height;
    }

    public double chuVi() {
        return (this.height + this.wight) * 2;
    }

    public void dislay() {
        System.out.println("Wight = " + wight);
        System.out.println("Height = " + height);
        System.out.println("Area = " + area());
        System.out.println("CV = " + chuVi());
    }
}
