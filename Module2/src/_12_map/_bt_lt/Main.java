package _12_map._bt_lt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager trong = new ProductManager();

        Product product;
        int id = 0;
        String name;
        int value;
        while (true) {
            int choice = 0;
            trong.menu();
            choice = trong.exceptionEnterTheNumber("choice");
            switch (choice) {
                case 1:
                    id = trong.readId();
                    id++;
                    System.out.println("Enter the infor: ");
                    System.out.print("name: ");
                    name = scanner.nextLine();
                    System.out.print("value= ");
                    value = trong.exceptionEnterTheNumber("value");
                    product = new Product(id, name, value);
                    trong.add(product);
                    trong.write(product);
                    break;
                case 2:
                    System.out.print("Edit the id: ");
                    id = trong.exceptionEnterTheNumber("id");
                    System.out.print("name: ");
                    name = scanner.nextLine();
                    System.out.print("value= ");
                    value = trong.exceptionEnterTheNumber("value");
                    product = new Product(id, name, value);
                    trong.set(id, product);
                    break;
                case 3:
                    System.out.print("Enter the id which you want to delete: ");
                    id = trong.exceptionEnterTheNumber("id");
                    trong.remove(id);
                    break;
                case 4:
                    System.out.print("Enter the name which you want to find: ");
                    name = scanner.nextLine();
                    trong.find(name);
                    break;
                case 5:
                    trong.tang();
                    break;
                case 6:
                    trong.giam();
                    break;
                case 7:
                    trong.showBiz();
                    break;
                case 8:
                    for (int i = 0; i < trong.read().size(); i++) {
                        System.out.println(trong.read().get(i));
                    }
//                    for (Product a : trong.read()) {
//                        System.out.println(a);
//                    }

                    break;
                case 9:
                    String removeName = scanner.nextLine();
                    trong.removeFileName(removeName);
                    System.out.println(trong.read());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("false chose !!!!");
            }
        }

    }
}
