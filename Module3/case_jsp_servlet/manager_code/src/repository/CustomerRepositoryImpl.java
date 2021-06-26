package repository;

import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    public static final String SELECT_CUSTOMER = "select customer.*, customer_type.customer_type_name from customer inner join customer_type on customer.customer_id = customer_type.customer_type_id;";

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
                    customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, new CustomerType(id_type,name_type));
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
                statement = connection.prepareCall("CALL create_customer(?,?,?,?,?,?,?,?,?)");
                statement.setInt(1, customer.getId());
                statement.setInt(2,customer.getCustomerType().getId());
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
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}
