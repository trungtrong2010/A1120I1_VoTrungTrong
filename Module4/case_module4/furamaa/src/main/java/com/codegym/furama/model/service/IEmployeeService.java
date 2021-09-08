package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> findAllSearch(String name, Optional<Integer> idDivision, Optional<Integer> idEducation, Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void remove(Employee employee);
}
