package repository.employee;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.*;
import model.user.User;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    public static final String SELECT_ALL_EMPLOYEE = "select employee.*, user.password, positionn.position_name, education_degree.education_degree_name, divition.divition_name from employee\n" +
            "left join positionn on employee.position_id = positionn.position_id\n" +
            "left join education_degree on employee.education_degree_id = education_degree.education_degree_id\n" +
            "left join divition on employee.divition_id = divition.divition_id\n" +
            "left join user on employee.username = user.username;";

    public static final String INSERT_INTO_EMPLOYEE = "INSERT INTO `furamar_jsp_servlet`.`employee` (`employee_id`, `employee_name`, `employee_birthday`, `employee_id_card`, `employee_salary`, `employee_phone`, `employee_email`, `employee_address`, `position_id`, `education_degree_id`, `divition_id`, `username`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

    public static final String UPDATE_EMPLOYEE = "UPDATE `furamar_jsp_servlet`.`employee` SET `employee_name` = ?, `employee_birthday` = ?, `employee_id_card` = ?, `employee_salary` = ?, `employee_phone` = ?, `employee_email` = ?, `employee_address` = ?, `position_id` = ?, `education_degree_id` = ?, `divition_id` = ?, `username` = ? WHERE (`employee_id` = ?);";

    public static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM `furamar_jsp_servlet`.`employee` WHERE (`employee_id` = ?);";
    public static final String SELECT_EMPLOYEE_BY_NAME = "select employee.*, user.password, positionn.position_name, education_degree.education_degree_name, divition.divition_name from employee\n" +
            "left join positionn on employee.position_id = positionn.position_id\n" +
            "left join education_degree on employee.education_degree_id = education_degree.education_degree_id\n" +
            "left join divition on employee.divition_id = divition.divition_id\n" +
            "left join user on employee.username = user.username\n" +
            "where employee_name =?;";
    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                Employee employee;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String birthday = resultSet.getString(3);
                    String idCard = resultSet.getString(4);
                    double salary = resultSet.getDouble(5);
                    String phone = resultSet.getString(6);
                    String email = resultSet.getString(7);
                    String address = resultSet.getString(8);
                    int idPosition = resultSet.getInt(9);
                    int idEducationDegree = resultSet.getInt(10);
                    int idDivition = resultSet.getInt(11);
                    String username = resultSet.getString(12);
                    String password = resultSet.getString(13);
                    String namePosition = resultSet.getString(14);
                    String nameEducationDegree = resultSet.getString(15);
                    String nameDivition = resultSet.getString(16);
                    list.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, new Position(idPosition, namePosition), new EducationDegree(idEducationDegree, nameEducationDegree), new Divition(idDivition, nameDivition), new User(username, password)));
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
    public Employee getEmployeeById(int id) {
        return selectAllEmployee().get(id);
    }

    @Override
    public void save(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);
                statement.setInt(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setString(3, employee.getBirthday());
                statement.setString(4, employee.getIdCard());
                statement.setDouble(5, employee.getSalary());
                statement.setString(6, employee.getPhone());
                statement.setString(7, employee.getEmail());
                statement.setString(8, employee.getAddress());
                statement.setInt(9, employee.getPosition().getId());
                statement.setInt(10, employee.getEducationDegree().getId());
                statement.setInt(11, employee.getDivition().getId());
                statement.setString(12, employee.getUser().getUsername());
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
    public void update(int id, Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getBirthday());
                preparedStatement.setString(3, employee.getIdCard());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setString(5, employee.getPhone());
                preparedStatement.setString(6, employee.getEmail());
                preparedStatement.setString(7, employee.getAddress());
                preparedStatement.setInt(8, employee.getPosition().getId());
                preparedStatement.setInt(9, employee.getEducationDegree().getId());
                preparedStatement.setInt(10, employee.getDivition().getId());
                preparedStatement.setString(11, employee.getUser().getUsername());
                preparedStatement.setInt(12, id);
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
                preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
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
    public List<Employee> getEmployeeByName(String name) {
        List<Employee> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);
                statement.setString(1, name);
                statement.executeQuery();
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String nameEmployee = resultSet.getString(2);
                    String birthday = resultSet.getString(3);
                    String idCard = resultSet.getString(4);
                    double salary = resultSet.getDouble(5);
                    String phone = resultSet.getString(6);
                    String email = resultSet.getString(7);
                    String address = resultSet.getString(8);
                    int idPosition = resultSet.getInt(9);
                    int idEducationDegree = resultSet.getInt(10);
                    int idDivition = resultSet.getInt(11);
                    String username = resultSet.getString(12);
                    String password = resultSet.getString(13);
                    String namePosition = resultSet.getString(14);
                    String nameEducationDegree = resultSet.getString(15);
                    String nameDivition = resultSet.getString(16);
                    list.add(new Employee(id, nameEmployee, birthday, idCard, salary, phone, email,
                            address, new Position(idPosition, namePosition), new EducationDegree(idEducationDegree,
                            nameEducationDegree), new Divition(idDivition, nameDivition), new User(username, password)));
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
