package _01_Introduction_to_Java._th;

import java.util.Scanner;

public class PtBac1 {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', Enter a b :");

        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();


        if (a!= 0){
            double solution= -b/a;
            System.out.printf("The solution is: " + solution);
        } else {
            if (b==0){
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
