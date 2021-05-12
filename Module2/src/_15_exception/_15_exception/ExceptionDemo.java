package _15_exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

    public void readFile() throws FileNotFoundException {
        FileReader reader = new FileReader("path");
    }

    public static int div() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        int a = 0;
        int b = 0;
        int c = 0;
        do {
            try {
                System.out.print("input number a: ");
                a = Integer.parseInt(scanner.nextLine());

                System.out.print("input number b: ");
                b = Integer.parseInt(scanner.nextLine());

                c = a/b;
                flag = false;
//            } catch (NumberFormatException e) {
//                flag = true;
//                System.out.println("Ban da nhap sai, vui long nhap lai");
//            } catch (ArithmeticException f){
//                flag = true;
//                System.out.println("Nhap b # 0");
//            } catch (Exception g){
//                flag = true;
//                System.out.println("Tinh nang dang duoc bao tri");
//                System.exit(0);
            } finally {
                System.out.println("da xu ly nhap xong");
            }
        } while (flag);

        return c;
    }


    /**
     * Phuong thuc xu ly nhap so
     *
     * @return number kieu int
     * @throws NumberFormatException
     */
    public static int inputNumber2() throws NumberFormatException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());

        return a;
    }

    public static void main(String[] args) {

        int number = div();


        System.out.print("output: " + number);
    }
}
