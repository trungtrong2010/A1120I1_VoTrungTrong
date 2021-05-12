//package _x_case_study._task2;
//
//import _x_case_study._task1._task1.House;
//import _x_case_study._task1._task1.Room;
//import _x_case_study._task1._task1.Villa;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class IO_Services {
//
//    private final String House_Link = "src/_x_case_study/_task2/House.csv";
//    private final String Room_Link = "src/_x_case_study/_task2/Room.csv";
//    private final String Villa_link = "src/_x_case_study/_task2/Villa.csv";
//    private final String p = ",";
//
//    public void writerHouse(House house) {
//
//        File file = new File(House_Link);
//        FileWriter fileWriter;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, true);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(house.getNameServices() + p + house.getArea() + p + house.getMoney() + p + house.getPeopleMax()
//                    + p + house.getRentalType() + p + house.getId() + p + house.getDvPlus()
//                    + p + house.getTieuChuanPhong() + p + house.getPaintedTienNghi() + p + house.getSoTang() + "\n");
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void writerRoom(Room room) {
//
//        File file = new File(Room_Link);
//        FileWriter fileWriter;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, true);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(room.getNameServices() + p + room.getArea() + p + room.getMoney() + p +
//                    room.getPeopleMax() + p + room.getRentalType() + p + room.getId() + p + room.getDvPlus() + p +
//                    room.getDvFree() + "\n");
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void writerVilla(Villa villa) {
//
//        File file = new File(Villa_link);
//        FileWriter fileWriter;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, true);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(villa.getNameServices() + p + villa.getArea() + p + villa.getMoney() + p +
//                    villa.getPeopleMax() + p + villa.getRentalType() + p + villa.getId() + p + villa.getDvPlus() + p +
//                    villa.getTieuChuanPhong() + p + villa.getPaintedTienNghi() + p + villa.getAreaHoBoi() + p + villa.getSoTang() + "\n");
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    //READ
//
//    public List<House> readHouse() {
//
//        List<House> list = new ArrayList<>();
//        File file = new File(House_Link);
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String line;
//            String[] temp;
//            House house;
//            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
//                temp = line.split(",");
//                house = new House(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4],
//                        temp[5], temp[6], temp[7], temp[8], Integer.parseInt(temp[9]));
//                list.add(house);
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<Room> readRoom() {
//
//        List<Room> list = new ArrayList<>();
//        File file = new File(Room_Link);
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String line;
//            String[] temp;
//            Room room;
//            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
//                temp = line.split(",");
//                room = new Room(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4],
//                        temp[5], temp[6], temp[7]);
//                list.add(room);
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<Villa> readVilla() {
//
//        List<Villa> list = new ArrayList<>();
//        File file = new File(Villa_link);
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String line;
//            String[] temp;
//            Villa villa;
//            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
//                temp = line.split(",");
//                villa = new Villa(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4],
//                        temp[5], temp[6], temp[7], temp[8], Integer.parseInt(temp[9]), Integer.parseInt(temp[10]));
//                list.add(villa);
//            }
//
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//}
