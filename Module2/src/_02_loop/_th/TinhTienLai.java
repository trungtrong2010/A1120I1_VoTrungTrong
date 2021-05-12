package _02_loop._th;

import java.util.Scanner;

public class TinhTienLai {
    public static void main(String[] args) {
        double money=1.0;
        int month=1;
        double interset_rate=1.0;

        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số tiền gửi: ");
        money= input.nextDouble();
        System.out.print("Nhập số tháng muốn gửi: ");
        month= input.nextInt();
        System.out.print("Nhập hệ số lãi suất : ");
        interset_rate= input.nextDouble();

        double total_interset = 0;
        for (int i = 0; i < month; i++){
            total_interset+= (money + total_interset)*(interset_rate/100)/12;
        }
        System.out.println("Total interset = "+total_interset);
    }
}
