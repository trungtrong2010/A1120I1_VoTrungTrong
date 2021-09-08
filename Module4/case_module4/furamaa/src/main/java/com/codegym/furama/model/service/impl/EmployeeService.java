package com.codegym.furama.model.service.impl;

import com.codegym.furama.model.entity.employee.Employee;
import com.codegym.furama.model.repository.employee.IEmployeeRepository;
import com.codegym.furama.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAllSearch(String name, Optional<Integer> idDivision, Optional<Integer> idEducation, Pageable pageable) {
        return this.employeeRepository.findAllByNameContainingAndDivisionAndEducation(name, idDivision, idEducation, pageable);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        this.employeeRepository.delete(employee);
    }
}
