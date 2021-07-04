package repository.service;

import model.service.RentType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryImpl implements RentTypeRepository {

    private static final String SELECT_ALL_RENT_TYPE = "SELECT * FROM furamar_jsp_servlet.rent_type;";
    private static final String SELECT_RENT_TYPE_BY_ID = "SELECT * FROM furamar_jsp_servlet.rent_type where rent_type_id = ?;";

    @Override
    public List<RentType> selectAllRentType() {
        List<RentType> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    list.add(new RentType(id, name));
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
    public RentType getRentTypeById(int id) {
        RentType rentType = new RentType();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_RENT_TYPE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    rentType = new RentType(id, name);
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
        return rentType;
    }
}
