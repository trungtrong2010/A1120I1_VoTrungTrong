package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {


    public static final String SELECT_ALL_USER = "SELECT * FROM users;";
    public static final String INSERT_NEW_USER = "INSERT INTO users(name,email,country) VALUES (?,?,?);";
    public static final String UPDATE_USER_ID = "update users set name=?,email=?,country=? where id=?;";
    public static final String DELETE_USER_MYSQL = "DELETE FROM users WHERE id = ?;";
    public static final String SELECT_COUNTRY = "select * from users where country=?;";
    public static final String SELECT_SORT_NAME = "select * from users order by name;";
    public static final String INSERT_USER_PERMISION = "INSERT INTO user_permision(user_id,permision_id) VALUES(?,?);";

    @Override
    public List<User> findAll() {
        List<User> listUser = new ArrayList<>();

        //b1 tao doi tuong connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1); //lay dc id
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);

                    listUser.add(user);
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
        return listUser;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement =null;
        try {
            callableStatement = connection.prepareCall("call insert_user(?,?,?)");
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.close();
        }
    }


    @Override
    public User findId(int id) {
        User user = null;
        Connection connection = DBConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getUserById(?);");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_USER_ID);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_USER_MYSQL);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<User> findByCountry(String indexCountry) {
        List<User> listCountry = new ArrayList<>();

        //b1 tao doi tuong connection
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_COUNTRY);
                statement.setString(1, indexCountry);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1); //lay dc id
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);

                    listCountry.add(user);
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
        return listCountry;
    }

    @Override
    public List<User> sortName() {
        List<User> listSortName = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_SORT_NAME);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1); //lay dc id
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);

                    listSortName.add(user);
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
        return listSortName;
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(INSERT_NEW_USER,Statement.RETURN_GENERATED_KEYS);
                statement.setString(1,user.getName());
                statement.setString(2,user.getEmail());
                statement.setString(3,user.getCountry());
                statement.executeUpdate();
                int rowAffected = statement.executeUpdate();

                resultSet = statement.getGeneratedKeys();

                int userId=0;

                if (resultSet.next()) {
                    userId = resultSet.getInt(1);
                }

                if (rowAffected == 1) {
                    statement = connection.prepareStatement(INSERT_USER_PERMISION);
                    for (int i = 0; i<permision.length;i++){
                        statement.setInt(1,userId);
                        statement.setInt(2,i);
                        statement.executeUpdate();
                    }
                    connection.commit();
                } else {
                    connection.rollback();
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
    }
}
