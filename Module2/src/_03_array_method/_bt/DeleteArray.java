package _03_array_method._bt;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{1,1,2,3,4,5,6,7,8,9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value arr[?] delete: ");
        int valueDel = scanner.nextInt();
        boolean check = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (valueDel == arr[i]) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = 0;
                count = i;
                check = true;
                i--;
            }
        }
        if (check) {
            System.out.println("Deleted arr[" + count + "]= " + valueDel);
            System.out.println("New Arr[]=" + Arrays.toString(arr));
        }else System.out.println("Not find");
    }
}
