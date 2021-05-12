package _14_sort;

import java.util.Arrays;

public class BubbleSort {
    public static int[] sort(int[] myArr) {
        int count = 0;
        boolean check = true;
        for (int i = 1; i < myArr.length && check; i++) {
            count++;
            check =false;
            for (int j = 0; j < myArr.length - i; j++) {
                count++;
                if (myArr[j] > myArr[j + 1]) {
                    int temp = myArr[j];
                    myArr[j] = myArr[j + 1];
                    myArr[j + 1] = temp;
                    check = true;
                }
            }
        }
        System.out.println(count);
        return myArr;
    }

    public static void main(String[] args) {
        int a[] = {11, 5, 3, 4, 6};
        int b[] = {1, 2, 4, 7, 8};
//        b = sort(b);
        a = sort(a);
        System.out.println(Arrays.toString(a));
    }
}
