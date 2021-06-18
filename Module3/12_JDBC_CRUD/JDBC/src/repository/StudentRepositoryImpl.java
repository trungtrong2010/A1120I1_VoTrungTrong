package repository;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    public static final String SELECT_ALL_STUDENT = "SELECT * FROM student";
    public static final String INSERT_NEW_STUDENT = "INSERT INTO student(name, gender, point, image) VALUE (?,?,?,?)";

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        //b1 tao doi tuong connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if(connection != null){
            try {
                statement = connection.prepareStatement(SELECT_ALL_STUDENT);
                resultSet = statement.executeQuery();

                Student student = null;
                while (resultSet.next()){
                    int id = resultSet.getInt(1); //lay dc id
                    String name = resultSet.getString("name");
                    int gender = resultSet.getInt("gender");
                    int point = resultSet.getInt("point");
                    String image = resultSet.getString("image");

                    student = new Student(id, name, gender, point, image);
                    studentList.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();

            }
        }

        return  studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if(connection != null){
            try {
                statement = connection.prepareStatement(INSERT_NEW_STUDENT);
                statement.setString(1, student.getName());
                statement.setInt(2, student.getGender());
                statement.setInt(3, student.getPoint());
                statement.setString(4, student.getImage());

                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void remove(int id) {

    }
}
