package repository.customer;

import model.customer.CustomerType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    public static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM customer_type;";

    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
                resultSet = statement.executeQuery();
                CustomerType customerType = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    customerType = new CustomerType(id, name);
                    list.add(customerType);
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
    public CustomerType findCustomerTypeById(int id) {
        return selectAllCustomerType().get(id);
    }
}
