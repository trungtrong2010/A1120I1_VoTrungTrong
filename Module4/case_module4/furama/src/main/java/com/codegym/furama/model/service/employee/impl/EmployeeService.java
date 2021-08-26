package com.codegym.furama.model.service.employee.impl;

import com.codegym.furama.model.entity.employee.Employee;
import com.codegym.furama.model.repository.employee.EmployeeRepository;
import com.codegym.furama.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return this.employeeRepository.findAllByNameContaining(name, pageable);
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
