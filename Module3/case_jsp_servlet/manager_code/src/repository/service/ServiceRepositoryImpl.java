package repository.service;

import model.employee.Divition;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;
import model.user.User;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {

    public static final String SELECT_ALL_SERVICE = "SELECT service.*,service_type.service_type_name, rent_type.rent_type_name FROM service\n" +
            "LEFT JOIN service_type ON service.service_type_id = service_type.service_type_id\n" +
            "LEFT JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id;";

    public static final String INSERT_INTO_SERVICE = "INSERT INTO `furamar_jsp_servlet`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

    public static final String SELECT_SERVICE_BY_ID = "SELECT service.*,service_type.service_type_name, rent_type.rent_type_name FROM service\n" +
            "LEFT JOIN service_type ON service.service_type_id = service_type.service_type_id\n" +
            "LEFT JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id\n" +
            "where service_id = ?;";

    public static final String UPDATE_SERVICE_BY_ID = "UPDATE `furamar_jsp_servlet`.`service` SET `service_name` = ?, `service_area` = ?, `service_cost` = ?, `service_max_people` = ?, `rent_type_id` = ?, `service_type_id` = ?, `standard_room` = ?, `description_other_convenience` = ?, `pool_area` = ?, `number_of_floors` = ? WHERE (`service_id` = ?);";

    public static final String DELETE_SERVICE_BY_ID = "DELETE FROM `furamar_jsp_servlet`.`service` WHERE (`service_id` = ?);";

    public static final String SELECT_SERVICE_BY_NAME = "SELECT service.*,service_type.service_type_name, rent_type.rent_type_name FROM service\n" +
            "LEFT JOIN service_type ON service.service_type_id = service_type.service_type_id\n" +
            "LEFT JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id\n" +
            "where service_name like concat('%',?,'%');";

    @Override
    public List<Service> selectAllService() {
        List<Service> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int area = resultSet.getInt(3);
                    double cost = resultSet.getDouble(4);
                    int maxPeople = resultSet.getInt(5);
                    int rentTypeId = resultSet.getInt(6);
                    int serviceTypeId = resultSet.getInt(7);
                    String standard_room = resultSet.getString(8);
                    String description_other_convenience = resultSet.getString(9);
                    double poolArea = resultSet.getDouble(10);
                    int number_of_floors = resultSet.getInt(11);
                    String rentTypeName = resultSet.getString(12);
                    String serviceTypeName = resultSet.getString(13);
                    list.add(new Service(id, name, area, cost, maxPeople, new RentType(rentTypeId, rentTypeName),
                            new ServiceType(serviceTypeId, serviceTypeName), standard_room, description_other_convenience, poolArea, number_of_floors));

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
    public void save(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_INTO_SERVICE);
                statement.setInt(1, service.getId());
                statement.setString(2, service.getName());
                statement.setInt(3, service.getArea());
                statement.setDouble(4, service.getCost());
                statement.setInt(5, service.getMaxPeople());
                statement.setInt(6, service.getRentType().getId());
                statement.setInt(7, service.getServiceType().getId());
                statement.setString(8, service.getStandardRoom());
                statement.setString(9, service.getDescription_other_convenience());
                statement.setDouble(10, service.getPool_area());
                statement.setInt(11, service.getNumber_of_floors());
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
    public Service getServiceById(int id) {
        Service service = new Service();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    int area = resultSet.getInt(3);
                    double cost = resultSet.getDouble(4);
                    int maxPeople = resultSet.getInt(5);
                    int rentTypeId = resultSet.getInt(6);
                    int serviceTypeId = resultSet.getInt(7);
                    String standard_room = resultSet.getString(8);
                    String description_other_convenience = resultSet.getString(9);
                    double poolArea = resultSet.getDouble(10);
                    int number_of_floors = resultSet.getInt(11);
                    String rentTypeName = resultSet.getString(12);
                    String serviceTypeName = resultSet.getString(13);
                    service = new Service(id, name, area, cost, maxPeople, new RentType(rentTypeId, rentTypeName),
                            new ServiceType(serviceTypeId, serviceTypeName), standard_room, description_other_convenience, poolArea, number_of_floors);

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
        return service;
    }

    @Override
    public void update(int id, Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_SERVICE_BY_ID);
                preparedStatement.setString(1, service.getName());
                preparedStatement.setInt(2, service.getArea());
                preparedStatement.setDouble(3, service.getCost());
                preparedStatement.setInt(4, service.getMaxPeople());
                preparedStatement.setInt(5, service.getRentType().getId());
                preparedStatement.setInt(6, service.getServiceType().getId());
                preparedStatement.setString(7, service.getStandardRoom());
                preparedStatement.setString(8, service.getDescription_other_convenience());
                preparedStatement.setDouble(9, service.getPool_area());
                preparedStatement.setInt(10, service.getNumber_of_floors());
                preparedStatement.setInt(11, id);
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
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
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
    public List<Service> getListServiceByName(String name) {
        List<Service> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_SERVICE_BY_NAME);
                statement.setString(1, name);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String nameService = resultSet.getString(2);
                    int area = resultSet.getInt(3);
                    double cost = resultSet.getDouble(4);
                    int maxPeople = resultSet.getInt(5);
                    int rentTypeId = resultSet.getInt(6);
                    int serviceTypeId = resultSet.getInt(7);
                    String standard_room = resultSet.getString(8);
                    String description_other_convenience = resultSet.getString(9);
                    double poolArea = resultSet.getDouble(10);
                    int number_of_floors = resultSet.getInt(11);
                    String rentTypeName = resultSet.getString(12);
                    String serviceTypeName = resultSet.getString(13);
                    list.add(new Service(id, nameService, area, cost, maxPeople, new RentType(rentTypeId, rentTypeName),
                            new ServiceType(serviceTypeId, serviceTypeName), standard_room, description_other_convenience, poolArea, number_of_floors));
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
