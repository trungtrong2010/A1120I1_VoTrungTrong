package repository.employee;

import model.employee.EducationDegree;
import model.employee.Position;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {

    public static final String SELECT_ALL_Education_Degree = "SELECT * FROM education_degree;";
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_Education_Degree);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    list.add(new EducationDegree(id, name));
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
    public EducationDegree getEducationDegreeById(int id) {
        return selectAllEducationDegree().get(id);
    }

}
