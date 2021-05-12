package _02_loop._bt;

import java.util.Scanner;

public class ShowHinh {
    public static void main(String[] args) {
        Scanner draw = new Scanner(System.in);
        System.out.println("* MENU:");
        System.out.println("1. HCN");
        System.out.println("2. tam giac");
        System.out.println("0. Exit");
        System.out.print("Enter the choice: ");
        while (true){
            int choice = draw.nextInt();
            switch (choice){
                case 1:
                    for (int i=0;i<5;i++){
                        for (int j =0; j<10; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (int i=0; i<5;i++){
                        for (int j=0; j<(5-i);j++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice ! ");
            }
        }
    }
}
