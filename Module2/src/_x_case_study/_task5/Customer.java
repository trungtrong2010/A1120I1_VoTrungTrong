package _x_case_study._task5;

import _x_case_study._task1._task1.House;
import _x_case_study._task1._task1.Room;
import _x_case_study._task1._task1.Services;
import _x_case_study._task1._task1.Villa;

import java.io.*;
import java.util.Scanner;

public class Customer {
    private String name;
    private String hpbd;
    private String gt;
    private long cmnd;
    private long numberPhone;
    private String email;
    private String loaiKhach;
    private String form;
    private Services dichVu;

    public Customer(String name, String hpbd, String gt, long cmnd, long numberPhone, String email, String loaiKhach, String form, Services dichVu) {
        this.name = name;
        this.hpbd = hpbd;
        this.gt = gt;
        this.cmnd = cmnd;
        this.numberPhone = numberPhone;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.form = form;
        this.dichVu = dichVu;
    }

    public Customer() {
    }



    public Customer(String name, String hpbd, String gt, long cmnd, long numberPhone, String email, String loaiKhach, String form) {
        this.name = name;
        this.hpbd = hpbd;
        this.gt = gt;
        this.cmnd = cmnd;
        this.numberPhone = numberPhone;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.form = form;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHpbd() {
        return hpbd;
    }

    public void setHpbd(String hpbd) {
        this.hpbd = hpbd;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public long getCmnd() {
        return cmnd;
    }

    public void setCmnd(long cmnd) {
        this.cmnd = cmnd;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Services getDichVu() {
        return dichVu;
    }

    public void setDichVu(Services dichVu) {
        this.dichVu = dichVu;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", hpbd='" + hpbd + '\'' +
                ", gt='" + gt + '\'' +
                ", cmnd=" + cmnd +
                ", numberPhone=" + numberPhone +
                ", email='" + email + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", form='" + form + '\'' +
                '}';
    }

    public void showInfor() {
        System.out.println(this.toString());
    }

    private final String LINK_CUSTOMER = "E:\\A1120I1\\Module2\\src\\_x_case_study\\_task5\\Customer.CSV";
    private final String P = ",";

    public void addNewCustomer() {
        File file = new File(LINK_CUSTOMER);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String hpbd = scanner.nextLine();
            String gt = scanner.nextLine();

            bufferedWriter.write(name + P + this.getHpbd() + P + this.getGt() + P + this.getCmnd() + P +
                    this.getNumberPhone() + P + this.getEmail() + P + this.getLoaiKhach() + P + this.getForm() + "\n");

//            System.out.print("Choice: " +
//                    "1. Services Villa" +
//                    "2. Services Room" +
//                    "3. Services House" +
//                    "Enter the choice: ");
//
//            Scanner scanner = new Scanner(System.in);
//            MainController scan = new MainController();
//            int choice = scan.exceptionInputNumber();
//            switch (choice) {
//                case 1:
//                    Villa villa = new Villa();
//                    bufferedWriter.write(villa.getNameServices() + P + villa.getArea() + P + villa.getMoney() + P +
//                            villa.getPeopleMax() + P + villa.getRentalType() + P + villa.getId() + P + villa.getDvPlus() + P +
//                            villa.getTieuChuanPhong() + P + villa.getPaintedTienNghi() + P + villa.getAreaHoBoi() + P + villa.getSoTang());
//                case 2:
//                    Room room = new Room();
//                    bufferedWriter.write(room.getNameServices() + P + room.getArea() + P + room.getMoney() + P +
//                            room.getPeopleMax() + P + room.getRentalType() + P + room.getId() + P + room.getDvPlus() + P + room.getDvFree());
//                case 3:
//
//            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showInformationCustomers() {

        File file = new File(LINK_CUSTOMER);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Customer customer;
            Services services = null;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                customer = new Customer(temp[0],temp[1], temp[2],Long.parseLong(temp[3]),Long.parseLong(temp[4]),
                        temp[5],temp[6],temp[7]);
                if(temp.length == 19){
                    services = new Villa(temp[8], Integer.parseInt(temp[9]), Integer.parseInt(temp[10]), Integer.parseInt(temp[11]),
                            temp[12], temp[13], temp[14], temp[15], temp[16], Integer.parseInt(temp[17]), Integer.parseInt(temp[18]));
                } else if (temp.length == 16) {
                    services = new Room(temp[8], Integer.parseInt(temp[9]), Integer.parseInt(temp[10]), Integer.parseInt(temp[11]),
                            temp[12], temp[13], temp[14], temp[15]);
                } else if (temp.length == 18) {
                    services = new House(temp[8], Integer.parseInt(temp[9]), Integer.parseInt(temp[10]), Integer.parseInt(temp[11]),
                            temp[12], temp[13], temp[14], temp[15], temp[16], Integer.parseInt(temp[17]));
                }
                customer.setDichVu(services);
                System.out.println(this.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Customer customer = new Customer("a","a","a",1234567901,123456789,"sad","asda","asd");
//        customer.addNewCustomer();
//        customer.showInformationCustomers();
//    }
}
