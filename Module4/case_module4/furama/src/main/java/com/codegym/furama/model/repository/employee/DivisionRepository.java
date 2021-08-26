package com.codegym.furama.model.repository.employee;

import com.codegym.furama.model.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
