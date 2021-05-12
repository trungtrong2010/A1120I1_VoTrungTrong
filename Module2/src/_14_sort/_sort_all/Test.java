package _14_sort._sort_all;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Proman> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int temp;
        do {
            System.out.print("arr[" + count + "]= ");
            temp = scanner.nextInt();
            if (temp != 0) {
                arr.add(new Proman(temp));
            }
            count++;
        } while (temp != 0 && count != 10);

        System.out.println(Arrays.toString(arr.toArray()));

        Collections.sort(arr);
        System.out.println(Arrays.toString(arr.toArray()));

        Collections.sort(arr, new TangGiam());
        System.out.println(Arrays.toString(arr.toArray()));

    }
}
