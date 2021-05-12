package _03_array_method._th;

import java.util.Scanner;

public class FindValueArray {
    public static void main(String[] args) {
        String[] student = {"Vo","Trung","Trong"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name student: ");
        String name = scanner.nextLine();

        boolean check=false;
        for (int i=0; i < student.length; i++){
            if (name.equals(student[i])){
                System.out.println(name + " : " + (i+1));
                check=true;
            }
        }
        if (!check) System.out.println("not find " + name);
    }
}
