package com.codegym.furama.model.service.employee;

import com.codegym.furama.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByNameContaining(String name, Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void remove(Employee employee);
}
