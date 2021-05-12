package _io_filetext._2;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReadFile {

    private static String LINK_FILE = "E:\\A1120I1\\Module2\\src\\_16_io_filetext\\_2\\file.csv";



    private static void read() {
        File file = new File(LINK_FILE);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                temp = line.split(",");
                System.out.println(temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read();
    }
}
