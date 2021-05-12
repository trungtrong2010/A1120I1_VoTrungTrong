package _11_stack_queue._stack._bt;

import java.util.Scanner;
import java.util.Stack;

public class StackString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> wStack = new Stack<>();

        System.out.print("nhap chuoi mWord: ");
        String mWord = scanner.nextLine();
        String[] temp = mWord.split(" ");

        for (int i = 0; i < temp.length; i++) {
            wStack.push(temp[i]);
        }

        int size = wStack.size();
        for (int i = 0; i < size; i++) {
            temp[i] = wStack.pop();
            System.out.println(temp[i]);
        }
        String outP = "";
        for (int i = 0; i < temp.length; i++) {
            outP += temp[i] + " ";
        }
        System.out.println(outP);
    }
}
