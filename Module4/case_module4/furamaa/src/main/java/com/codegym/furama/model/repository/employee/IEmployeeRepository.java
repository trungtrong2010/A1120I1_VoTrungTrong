package com.codegym.furama.model.repository.employee;

import com.codegym.furama.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e from Employee e where (e.name like %:nameSearch%) and (:idDivisionSearch is null or e.division.id =:idDivisionSearch) and (:idEducationDegreeSearch is null or e.educationDegree.id =:idEducationDegreeSearch)")
    Page<Employee> findAllByNameContainingAndDivisionAndEducation(@Param("nameSearch") String nameSearch, @Param("idDivisionSearch") Optional<Integer> idDivisionSearch, @Param("idEducationDegreeSearch") Optional<Integer> idEducationDegreeSearch, Pageable pageable);
}
