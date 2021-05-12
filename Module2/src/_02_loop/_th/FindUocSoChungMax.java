package _02_loop._th;

import java.util.Scanner;

public class FindUocSoChungMax  {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner input=new Scanner(System.in);
        // Ham abs(): tri tuyet doi |X|
        System.out.print("Nhập số nguyên a: ");
        a = Math.abs(input.nextInt());
        System.out.print("Nhập số nguyên b: ");
        b = Math.abs(input.nextInt());

        if (a == 0 || b == 0)
            System.out.println("Not UCLN !");
        else {
            while (a != b) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            System.out.println("UCLN= " + a);
        }
    }
}
