package _03_array_method._bt;

import java.util.Arrays;
import java.util.Scanner;

public class GopArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] arr;
        int[] arr1 = new int[0];
        int[] arr2 = new int[0];
        int[] arr3 = new int[0];
        int size;
        int count =0;

        do {
            count++;
            do {
                System.out.print("Enter size arr" + count + ": ");
                size = scanner.nextInt();
                if (size > 5 || size <= 0)
                    System.out.println("size = (0;5] ");
            } while (size > 5 || size <= 0);
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + " : ");
                arr[i] = scanner.nextInt();
            }
            if (count == 1) {
                arr1 = arr;
                System.out.println("arr1= " + Arrays.toString(arr1));
            } else if (count == 2) {
                arr2 = arr;
                System.out.println("arr2= " + Arrays.toString(arr2));
            }else {
                arr3 = arr;
                System.out.println("arr3= " + Arrays.toString(arr3));
            }
        } while (count <3);

        arr = new int[arr1.length + arr2.length + arr3.length];
        for (int i = 0; i < arr.length; i++) {
            if (i < arr1.length) {
                arr[i] = arr1[i];
            }else if (i < arr1.length + arr2.length){
                arr[i] = arr2[i - arr1.length];
            }else {
                arr[i] = arr3[i - arr1.length - arr2.length];
            }
        }
        System.out.println("**********RESSULT***********");
        System.out.println("arr[]= " + Arrays.toString(arr));
    }
}
