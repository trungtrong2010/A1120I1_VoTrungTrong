package _03_array_method._th;


import java.util.Arrays;
import java.util.Scanner;

public class FindValueMax {
    public static void main(String[] args) {
        int size;
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter size: ");
            size = scanner.nextInt();
            if (size > 20 || size < 0)
                System.out.println("faid ! size = [0;20] ");
        } while (size > 20 || size < 0);

        arr = new int[size];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ": ");
            arr[i] = scanner.nextInt();
            if (max < arr[i])
                max = arr[i];
        }
        System.out.println("max= " + max);
    }
}
