package _a_case._exception_scanner;

import java.util.Scanner;

public class ExceptionInputNumber {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * try catch scanner
     * @return scanner.nextInt();
     */
    public static int exceptionIpInt() {
        int temp = 0;
        boolean checkException = false;
        do {
            try {
                temp = Integer.parseInt(scanner.nextLine());
                checkException = false;
            } catch (NumberFormatException n) {
                System.out.println("Number false ! ! !" + "\n" + "Re-enter number: ");
                checkException = true;
            }
        } while (checkException);
        return temp;
    }

//    public static  boolean
//
//    public static long exceptionIpLong() {
//        long temp = 0;
//        boolean check = false;
//        do {
//            try {
//                temp = Long.parseLong(scanner.nextLine());
//                check = false;
//            } catch (NumberFormatException n) {
//
//            }
//
//        }
//    }

    public static void main(String[] args) {
        System.out.print("dô: ");
        exceptionIpInt();
    }
}
