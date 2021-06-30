package repository.customer;

import model.Customer;
import model.CustomerType;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String INSERT_SQL = "INSERT INTO customer" + "  (name, id_card," +
            " phone, id_customer_type) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select customer.id, customer_type.id_customer_type, customer_type.customer_type_name, customer.name, customer.id_card, customer.phone from customer join customer_type " +
            "on customer.id_customer_type = customer_type.id_customer_type where customer.id =?";

    private static final String SELECT_ALL = "select  customer.*, customer_type.* from customer join customer_type " +
            "on customer.id_customer_type = customer_type.id_customer_type";


    private static final String DELETE_SQL = "delete from customer where id = ?;";

    private static final String UPDATE_SQL = "update customer set name = ?, id_card = ?," +
            " phone = ?, id_customer_type = ? where id = ?;";

    public Customer findById(int id) {
        Customer customer = null;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                int id_customer_type = resultSet.getInt("id_customer_type");
                String customerTypeName = resultSet.getString("customer_type_name");
                customer = new Customer(id,name, idCard, phone, new CustomerType(id_customer_type, customerTypeName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return customer;
    }

    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getIdCard());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setInt(4, customer.getCustomerType().getId());
            preparedStatement.setInt(5, customer.getId());
            System.out.println(preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowUpdate;
    }

    public void insert(Customer customer) throws SQLException {
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getIdCard());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setInt(4, customer.getCustomerType().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);
        } finally {
            ConnectionSQL.close();
        }
    }

    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                String customerTypeName = resultSet.getString("customer_type_name");
                int idCustomerType = resultSet.getInt("id_customer_type");
                customerList.add(new Customer(id, name, idCard, phone, new CustomerType(idCustomerType, customerTypeName)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return customerList;
    }

    private void printSQLException(SQLException e) {
    }
}
