package demo;

import _a_case._exception_scanner.ExceptionInputNumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoEmail {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
//        boolean check = true;
//        while (check){
//            System.out.print("Input email: ");
//            String email = scanner.nextLine();
//            Matcher a = p.matcher(email);
//            if (a.find()) {
//                check=false;
//                System.out.println(email+" hợp lệ");
//            }
//        }

        int a = ExceptionInputNumber.exceptionIpInt();
        int b = ExceptionInputNumber.exceptionIpInt();
    }
}
