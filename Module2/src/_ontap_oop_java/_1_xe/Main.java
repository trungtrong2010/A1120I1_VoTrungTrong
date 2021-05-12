package _ontap_oop_java._1_xe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle;
        double value;
        double capacity;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> listVehicle = new ArrayList<>();

        do {
            System.out.println("\n" + "1. Tạo các đối tượng xe và nhập thông tin");
            System.out.println("2. Xuất bảng kê khai tiền thuế của các xe");
            System.out.println("0. Thoát");
            System.out.print("Enter the number choose your: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.print("\nEnter value vehicle : ");
                    value = scanner.nextDouble();
                    System.out.print("Enter capacity vehicle : ");
                    capacity = scanner.nextDouble();
                    vehicle = new Vehicle(value, capacity);
                    listVehicle.add(vehicle);
                    break;
                case 2:
                    if (listVehicle.size() == 0) {
                        System.out.println("\nNot Infor !!!");
                    }else System.out.println(listVehicle);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Not number !!!");
            }
        } while (true);

    }
}
