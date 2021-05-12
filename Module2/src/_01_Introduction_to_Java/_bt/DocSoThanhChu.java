package _01_Introduction_to_Java._bt;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int i = scanner.nextInt();

        if (  i >=0){
            switch (i){
                case 0:
                    System.out.print("zero");
                case 1:
                    System.out.print("one");
            }
        }
    }
}
