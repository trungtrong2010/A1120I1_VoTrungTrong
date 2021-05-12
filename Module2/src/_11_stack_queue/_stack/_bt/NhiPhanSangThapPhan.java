package _11_stack_queue._stack._bt;

import java.util.Scanner;
import java.util.Stack;

public class NhiPhanSangThapPhan {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean check = false;

        do {
            Stack<Character> nhiPhan = new Stack<>();
            int result = 0;
            int count = 0;
            System.out.print("Enter the number: ");
            // String to Char[]
            char[] arr = scanner.nextLine().toCharArray();
            for (int i = arr.length - 1; i >= 0; i--) {
                // push( 0 to arr.length)
                nhiPhan.push(arr[arr.length - 1 - i]);
                if (arr[i] == '0') {
                    count++;
                }
                if (arr[i] == '1') {
                    result += Math.pow(2.0, count);
                    count++;
                }
            }
            if (count == arr.length) {
                check = true;
                System.out.println("result= " + result);
                System.out.print("Number= ");
                while (!nhiPhan.isEmpty()) {
                    System.out.print(nhiPhan.pop());
                }
            }
        } while (!check);
    }
}