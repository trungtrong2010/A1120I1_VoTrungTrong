package _01_Introduction_to_Java._bt;

import java.util.Scanner;

public class ShowName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("hello "+ name);
    }
}
