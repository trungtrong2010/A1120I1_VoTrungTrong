package _12_map._bt_lt;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private List<Product> list = new ArrayList<>();


    public ProductManager() {
    }

    public void menu() {
        System.out.println("*****MENU*****");
        System.out.println("1. Add");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. Find the name");
        System.out.println("5. Sắp xếp value tăng dần");
        System.out.println("6. Sắp xếp value giảm dần");
        System.out.println("7. Show");
        System.out.println("8. Read file");
        System.out.println("9. Remove file to name");
        System.out.println("0. EXIT\n--------");
        System.out.print("Enter the choise your: ");
    }

    public void add(Product product) {
        list.add(product);
    }

    public void set(int id, Product product) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, product);
            }
        }
    }

    public void remove(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
    }


    public void showBiz() {
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public void find(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName())) {
                System.out.println(list.get(i));
            }
        }
    }

    public void tang() {
        Collections.sort(list);
        showBiz();
    }

    public void giam() {
        Collections.sort(list, new SxepGiam());
        showBiz();
    }

    public final String LINK = "E:\\A1120I1\\Module2\\src\\_12_map\\_bt_lt\\product.csv";
    public final String P = ",";

    public void write(Product product) {
        File file = new File(LINK);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(product.getId() + P + product.getName() + P + product.getValue() + "\n");
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

    public List<Product> read() {
        List<Product> list = new ArrayList<>();
        File file = new File(LINK);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] temp;
            String line;
            Product product;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()){
                temp = line.split(",");
                product = new Product(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
                list.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int readId() {
        int readId = 0;
        File file = new File(LINK);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] temp;
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()){
                temp = line.split(",");
                readId = Integer.parseInt(temp[0]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readId;
    }

    public void removeFileName(String name) {
        List<Product> list = new ArrayList<>();

        for (int i = 0; i < read().size(); i++) {
            if (read().get(i).getName().equals(name)) {
                continue;
            }
            list.add(read().get(i));
        }
        File file = new File(LINK);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i).getId() + P + list.get(i).getName() + P + list.get(i).getValue() + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * @param choiceIdValue= choice || id || value
     * @return temp
     */
    public int exceptionEnterTheNumber(String choiceIdValue) {
        Scanner number = new Scanner(System.in);
        int temp = 0;
        boolean check = false;
        do {
            try {
                temp = Integer.parseInt(number.nextLine());
                check = false;
            } catch (NumberFormatException t) {
                System.out.println("Number false !!!");
                if (choiceIdValue.equals("choice")) {
                    System.out.print("Re-enter your choice : ");
                } else if (choiceIdValue.equals("id")) {
                    System.out.print("Re-enter the ID: ");
                } else if (choiceIdValue.equals("value")) {
                    System.out.print("Re-enter the value: ");
                } else System.out.print("Enter code String false ** or ** Re-enter the number: ");

                check = true;
            }
        } while (check);
        return temp;
    }
}