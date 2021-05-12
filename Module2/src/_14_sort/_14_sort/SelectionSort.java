package _14_sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minValue = array[i];
            int minIndex = i;

            for(int j=i+1; j < array.length; j++){
                if(minValue > array[j]){
                    minValue = array[j];
                    minIndex = j;
                }
            }

            if(minIndex!=i){
                int temp = array[i];
                array[i] = minValue;
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] myArray = {2, 9, 5, 4, 8, 1};
        sort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
