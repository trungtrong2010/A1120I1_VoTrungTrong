package _04_class_object._bt;

import java.util.Scanner;

public class Fan {
    int speed;
    int radius = 5;
    String color = "blue";
    static Scanner scanner = new Scanner(System.in);

    public Fan() {
    }

    public Fan(int speed, int radius, String color) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }


    public String toString() {
        return "Speed : " + this.speed + "\nRadius : " + this.radius + "\nColor : " + this.color;
    }

    public static int speed() {
        System.out.print("Enter the speed: ");
        return scanner.nextInt();
    }

    public static int radius() {
        System.out.print("Enter the radius: ");
        return scanner.nextInt();
    }

    public static String color() {
        System.out.print("Enter the color: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(speed(), radius(), color());
        System.out.println("***Fan1***\n" + fan1.toString());
        Fan fan2 = new Fan(speed(), radius(), color());
        System.out.println("***Fan2***\n" + fan2.toString());
    }
}
