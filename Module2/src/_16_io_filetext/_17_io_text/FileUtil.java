//package _17_io_textfile;
//
//import _15_exception.Student;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FileUtil {
//
//    public static final String FILE_PATH = "D:\\SynologyDrive\\Dell5590\\Work\\CodeGym\\Class\\A1120I1\\Module2\\SourceDemo\\src\\_17_io_textfile\\student.csv";
//    public static final String COMMA = ",";
//
//    public static void writeCSV(Student student){
//        File file = new File(FILE_PATH);
//        FileWriter fileWriter = null;
//        BufferedWriter buffWrite = null;
//        try {
//            fileWriter = new FileWriter(file, true);
//            buffWrite = new BufferedWriter(fileWriter);
//            buffWrite.write(student.getId()+ COMMA +student.getName()+"\n");
//            buffWrite.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(buffWrite!=null){
//                    buffWrite.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static List<Student> readCSV(){
//        List<Student> studentList = new ArrayList<>();
//        File file = new File(FILE_PATH);
//
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader buffRead = new BufferedReader(fileReader);
//
//            String line;
//            Student student;
//            String[] temp;
//            while ((line = buffRead.readLine()) !=null && !line.isEmpty()){
//                temp = line.split(",");
//                student = new Student(Integer.parseInt(temp[0]), temp[1]);
//                studentList.add(student);
//            }
//            buffRead.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return studentList;
//    }
//
//    public static void main(String[] args) {
////        writeCSV(new Student(2, "Thanh"));
//        List<Student> studentList = readCSV();
//
//        for (Student student: studentList){
//            System.out.println(student);
//        }
//    }
//}
