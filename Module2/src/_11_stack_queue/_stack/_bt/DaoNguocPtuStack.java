package _11_stack_queue._stack._bt;


import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPtuStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> integerStack = new Stack<>();

        System.out.print("Nhap size cua mang: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("arr[" + i + "]= ");
            arr[i] = scanner.nextInt();
        }

        System.out.println("--------stack--------");
        for (int i = 0; i < size; i++) {
            System.out.print(integerStack.push(arr[i]) + "\t");
        }

        System.out.println("\n----newArray----");
        for (int i = 0; i < size; i++) {
            arr[i] = integerStack.pop();
            System.out.print(arr[i] + "\t");
        }
    }
}
