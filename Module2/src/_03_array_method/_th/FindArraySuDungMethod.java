package _03_array_method._th;

import java.util.Scanner;

public class FindArraySuDungMethod {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = input.nextInt();
         int [] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter array[" + i + "]= ");
            array[i] = input.nextInt();
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("min= " + min);
    }
}
