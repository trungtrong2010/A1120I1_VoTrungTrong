package _x_case_study._task2;

import _x_case_study._task1._task1.House;
import _x_case_study._task1._task1.Room;
import _x_case_study._task1._task1.Villa;

import java.util.*;

public class MainController {

    Scanner scanner = new Scanner(System.in);
    IO_Services io_services = new IO_Services();
    int choice;

    /**
     * Exception input Number not String
     * @return temp = Integer.parseInt(scanner.nextLine())
     **/
    public int exceptionInputNumber() {
        int temp = 0;
        boolean checkException = false;
        do {
            try {
                temp = Integer.parseInt(scanner.nextLine());
                checkException = false;
            } catch (NumberFormatException n) {
                System.out.println("Number false ! ! !");
                System.out.print("Re-enter number: ");
                checkException = true;
            }
        } while (checkException);
        return temp;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("1. Add New Services\n" +
                    "2. Show Services\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information of Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Exit");
            System.out.print("Enter the choice: ");
            choice = exceptionInputNumber();
            switch (choice) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;

            }
        }
    }

    public void addNewServices() {
        while (true) {
            System.out.println("---------\n" +
                    "1. Add New Villa\n" +
                    "2. Add New House\n" +
                    "3. Add New Room\n" +
                    "4. Back to menu\n" +
                    "5. Exit");
            System.out.print("Enter the choice: ");
            choice = exceptionInputNumber();
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.print("nameServices: ");
                String nameServices = scanner.nextLine();
                System.out.print("area= ");
                int area = exceptionInputNumber();
                System.out.print("money= ");
                int money = exceptionInputNumber();
                System.out.print("peopleMax= ");
                int peopleMax = exceptionInputNumber();
                System.out.print("rentalType: ");
                String rentalType = scanner.nextLine();
                System.out.print("id= ");
                String id = scanner.nextLine();
                System.out.print("dvPlus: ");
                String dvPlus = scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("tieuchuanPhong: ");
                        String tieuChuanPhong = scanner.nextLine();
                        System.out.print("paintedTienNghi: ");
                        String paintedTienNghi = scanner.nextLine();
                        System.out.print("areaHoBoi= ");
                        int areaHoBoi = exceptionInputNumber();
                        System.out.print("soTang= ");
                        int soTang = exceptionInputNumber();
                        Villa villa = new Villa(nameServices, area, money, peopleMax, rentalType,
                                id, dvPlus, tieuChuanPhong, paintedTienNghi, areaHoBoi, soTang);
                        io_services.writerVilla(villa);
                        break;
                    case 2:
                        System.out.print("tieuchuanPhong: ");
                        tieuChuanPhong = scanner.nextLine();
                        System.out.print("paintedTienNghi: ");
                        paintedTienNghi = scanner.nextLine();
                        System.out.print("soTang= " + "\n");
                        soTang = exceptionInputNumber();
                        House house = new House(nameServices, area, money, peopleMax, rentalType,
                                id, dvPlus, tieuChuanPhong, paintedTienNghi, soTang);
                        io_services.writerHouse(house);
                        break;
                    case 3:
                        System.out.print("dvFree: ");
                        String dvFree = scanner.nextLine();
                        Room room = new Room(nameServices, area, money, peopleMax, rentalType, id, dvPlus, dvFree);
                        io_services.writerRoom(room);
                        break;
                }
            } else if (choice == 4) {
                displayMainMenu();
                break;
            } else if (choice == 5) {
                System.exit(0);
            } else System.out.println("enter number choice faile !!! ");
        }
    }

    public void showServices() {
        while (true) {
            System.out.println("---------\n" +
                    "1. Show all Villa\n" +
                    "2. Show all House\n" +
                    "3. Show all Room\n" +
                    "4. Show All Name Villa Not Duplicate\n" +
                    "5. Show All Name House Not Duplicate\n" +
                    "6. Show All Name Name Not Duplicate\n" +
                    "7. Back to menu\n" +
                    "8. Exit");
            System.out.print("Enter the choice: ");
            choice = exceptionInputNumber();
            switch (choice) {
                case 1:
                    System.out.println(io_services.readVilla());
                    break;
                case 2:
                    System.out.println(io_services.readHouse());
                    break;
                case 3:
                    System.out.println(io_services.readRoom());
                    break;
                case 4:
                    showNameVilla();
                    break;
                case 5:
                    showNameHouse();
                    break;
                case 6:
                    showNameRoom();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("The choice false !! ");
            }
        }
    }

    public void showNameVilla() {
        TreeSet<String> nameVilla = new TreeSet<>();
        for (Villa villa : io_services.readVilla()) {
            nameVilla.add(villa.getNameServices());
        }
        System.out.println(nameVilla);
    }

    public void showNameHouse() {
        TreeSet<String> nameHouse = new TreeSet<>();
        for (House house : io_services.readHouse()) {
            nameHouse.add(house.getNameServices());
        }

        System.out.println(nameHouse);
    }

    public void showNameRoom() {
        TreeSet<String> nameRoom = new TreeSet<>();
        for (Room room : io_services.readRoom()) {
            System.out.println(room.getNameServices());
            nameRoom.add(room.getNameServices());
        }
        System.out.println(nameRoom);
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}