package _io_filetext._1;

import _12_map._bt_lt.Product;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class OI {
    public static final String File_txt = "src/_io_filetext/file.txt";
    public static final String Coppy_txt = "src/_io_filetext/coppy.txt";

    public static List<Product> readCsvAndCoppyFile() {
        List<Product> list = new ArrayList<>();
        File file = new File(File_txt);
        try {
            File fileCoppy = new File(Coppy_txt);
            FileWriter fileWriter = new FileWriter(fileCoppy);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Product product;
            String[] temp;
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                product = new Product(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]));
                list.add(product);
                System.out.println(product.getId());
                bufferedWriter.write(String.valueOf(product.getId()) + ','
                        + product.getName() + ',' + String.valueOf(product.getValue()) + "\n");
            }
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<Product> list = readCsvAndCoppyFile();
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
