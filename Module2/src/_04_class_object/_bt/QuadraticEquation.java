package _04_class_object._bt;

import javax.swing.*;
import java.util.Scanner;

public class QuadraticEquation {
    int a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDelta() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.pow(getDelta(), 0.5)) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.pow(getDelta(), 0.5)) / (2 * a);
    }

    public void display() {
        if (getDelta() > 0) {
            System.out.println("Phương trình có 2 nghiệm: ");
            System.out.println("x1 = " + getRoot1());
            System.out.println("x2 = " + getRoot2());
        } else if (getDelta() == 0) {
            System.out.println("Phương trình có 2 nghiệm kép: ");
            System.out.println("x1 = x2 = " + getRoot1());
        } else System.out.println("Phương trình vô nghiệm !");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the a : ");
        int a = scanner.nextInt();
        System.out.print("Enter the b : ");
        int b = scanner.nextInt();
        System.out.print("Enter the c : ");
        int c = scanner.nextInt();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        quadraticEquation.display();
    }
}
