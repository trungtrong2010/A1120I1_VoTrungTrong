package repository;

import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    public static final String SELECT_CUSTOMER = "select customer.*, customer_type.customer_type_name from customer left join customer_type\n" +
            "on customer.customer_type_id = customer_type.customer_type_id;";
    public static final String UPDATE_CUSTOMER_BY_ID = "UPDATE customer SET customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email= ?, customer_address = ? WHERE customer_id = ?;";
    public static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE customer_id = ?;";
    public static final String SELECT_CUSTOMER_BY_NAME = "select customer.*, customer_type.customer_type_name from customer left join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name = ?;";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER);

                resultSet = statement.executeQuery();

                Customer customer = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int id_type = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    String birthday = resultSet.getString(4);
                    int gender = resultSet.getInt(5);
                    String idCard = resultSet.getString(6);
                    String phone = resultSet.getString(7);
                    String email = resultSet.getString(8);
                    String address = resultSet.getString(9);
                    String name_type = resultSet.getString(10);
                    customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, new CustomerType(id_type, name_type));
                    list.add(customer);
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
        return list;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("CALL create_customer(?,?,?,?,?,?,?,?,?);");
                statement.setInt(1, customer.getId());
                statement.setInt(2, customer.getCustomerType().getId());
                statement.setString(3, customer.getName());
                statement.setString(4, customer.getBirthday());
                statement.setInt(5, customer.getGender());
                statement.setString(6, customer.getIdCard());
                statement.setString(7, customer.getPhone());
                statement.setString(8, customer.getEmail());
                statement.setString(9, customer.getAddress());
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
    public Customer getCustomerById(int id) {
        return selectAllCustomer().get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, customer.getCustomerType().getId());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getBirthday());
                preparedStatement.setInt(4, customer.getGender());
                preparedStatement.setString(5, customer.getIdCard());
                preparedStatement.setString(6, customer.getPhone());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
                preparedStatement.setInt(9, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
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
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        List<Customer> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
                statement.setString(1, name);
                statement.executeQuery();
                resultSet = statement.executeQuery();
                Customer customer = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int id_type = resultSet.getInt(2);
                    String birthday = resultSet.getString(4);
                    int gender = resultSet.getInt(5);
                    String idCard = resultSet.getString(6);
                    String phone = resultSet.getString(7);
                    String email = resultSet.getString(8);
                    String address = resultSet.getString(9);
                    String name_type = resultSet.getString(10);
                    customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, new CustomerType(id_type, name_type));
                    list.add(customer);
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
        return list;
    }
}
