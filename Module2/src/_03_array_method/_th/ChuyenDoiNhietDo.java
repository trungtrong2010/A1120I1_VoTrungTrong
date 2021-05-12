package _03_array_method._th;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static double doCF(double c) {
        return (9.0 / 5) * c + 32;
    }

    public static double doFC(double f) {
        return (5.0 / 9) * (f - 32);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double f;
        double c;
        int choice;
        do {
            System.out.println("* MENU: ");
            System.out.println("1.C sang F");
            System.out.println("2. F sang C");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter C: ");
                    f = input.nextDouble();
                    System.out.println("F= " + doCF(f));
                    break;
                case 2:
                    System.out.println("Enter F: ");
                    c = input.nextDouble();
                    System.out.println("C= " + doFC(c));
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice !");
            }
        } while (choice != 0);
    }
}
