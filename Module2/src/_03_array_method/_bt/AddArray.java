package _03_array_method._bt;

import java.util.Arrays;
import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr;
        int size;
        int indexAdd;

        //Enter the array
        do {
            System.out.print("Enter size Array: ");
            size = scanner.nextInt();
            if (size > 20 || size < 0)
                System.out.println("size = [0;20] ");
        }while (size > 20 || size < 0);
        arr = new int[size];
        for (int i =0; i < arr.length; i++){
            System.out.print((i+1)+" : ");
            arr[i] = scanner.nextInt();
        }

        // Enter the index add
        do {
            System.out.println("Enter the index to add: ");
            indexAdd = scanner.nextInt();
            if (0 >= indexAdd || indexAdd >= arr.length -1)
                System.out.println("********Index not suitable********");
        } while (0 >= indexAdd || indexAdd >= arr.length -1);

        System.out.println("Enter the required value: ");
        int valueAdd = scanner.nextInt();

        // add value to the array in index
        for (int i = arr.length -1; i != indexAdd  ; i--) {
            arr[i] = arr[i - 1];
        }
        arr[indexAdd] = valueAdd;
        System.out.println("Added arr[" + indexAdd + "] =" + valueAdd);
        System.out.println("New Array: arr[]=" + Arrays.toString(arr));
    }
}
