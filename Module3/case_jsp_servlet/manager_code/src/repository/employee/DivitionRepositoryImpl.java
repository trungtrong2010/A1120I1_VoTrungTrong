package repository.employee;

import model.employee.Divition;
import model.employee.Position;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivitionRepositoryImpl implements DivitionRepository {

    public static final String SELECT_ALL_DIVITION = "SELECT * FROM divition;";


    @Override
    public List<Divition> selectAllDivition() {
        List<Divition> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_DIVITION);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    list.add(new Divition(id, name));
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
    public Divition getDivitionById(int id) {
        return selectAllDivition().get(id);
    }
}
