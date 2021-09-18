package com.codegym.test1.model.repository;

import com.codegym.test1.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student where name like %?1%", nativeQuery = true)
    List<Student> findAllByNameContaining(String name);
}
