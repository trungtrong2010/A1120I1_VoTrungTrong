package com.codegym.furama.model.repository.employee;

import com.codegym.furama.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
