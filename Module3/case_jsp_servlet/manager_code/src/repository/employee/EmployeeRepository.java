package repository.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> selectAllEmployee();

    Employee getEmployeeById(int id);

    void save(Employee employee);

    void update(int id, Employee employee);

    void delete(int id);

    List<Employee> getEmployeeByName(String name);

}
