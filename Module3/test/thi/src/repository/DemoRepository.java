package repository;

import model.Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DemoRepository {
    public List<Demo> selectAllDemo() {
        List<Demo> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("select * from test;");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    double dienTich = resultSet.getDouble(2);
                    String trangThai = resultSet.getString(3);
                    int tang = resultSet.getInt(4);
                    String loaiVanPhong = resultSet.getString(5);
                    String moTaChiTiet = resultSet.getString(6);
                    double giaChoThue = resultSet.getDouble(7);
                    String ngayBatDau = resultSet.getString(8);
                    String ngayKetThuc = resultSet.getString(9);
                    list.add(new Demo(id, dienTich, trangThai, tang, loaiVanPhong, moTaChiTiet, giaChoThue, ngayBatDau, ngayKetThuc));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return list;
    }
}
