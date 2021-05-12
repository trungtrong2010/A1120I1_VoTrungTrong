package _02_loop._bt;

import java.util.Scanner;

public class Show20SoNguyeTo {
    public static void main(String[] args) {
        Scanner soNguyenTo = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = soNguyenTo.nextInt();
        int count=1;
            for (int i = 2; i < number; i++) {
                int check=0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        check++;
                    }
                }
                if (check == 2) {
                    System.out.println(count + ". " + i);
                    count++;
                }
                if (count >20) break;
            }
    }
}
