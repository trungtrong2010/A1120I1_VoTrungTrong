package repository.employee;

import model.user.User;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String SELECT_ALL_USER = "SELECT * FROM user;";
    public static final String SELECT_USER_BY_NAME = "SELECT * FROM user where username=?;";

    @Override
    public List<User> selectAllUser() {
        List<User> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USER);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String username = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    list.add(new User(username, password));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
            return list;
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_NAME);
                statement.setString(1, username);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    user = new User(name, password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return user;
    }
}
