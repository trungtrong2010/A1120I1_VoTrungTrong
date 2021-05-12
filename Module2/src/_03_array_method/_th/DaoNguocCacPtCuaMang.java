package _03_array_method._th;

import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocCacPtCuaMang {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter size Array: ");
            size = scanner.nextInt();
            if (size > 20 || size < 0)
                System.out.println("size = [0;20] ");
        }while (size > 20 || size < 0);

        int arr[];
        arr = new int[size];
        for (int i =0; i < arr.length; i++){
            System.out.print((i+1)+" : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Ban dau: arr="+ Arrays.toString(arr));

        for (int i=0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[size -1 - i];
            arr[size -1 -i]=temp;
        }
        System.out.println("Dao nguoc: arr="+ Arrays.toString(arr));
    }
}

