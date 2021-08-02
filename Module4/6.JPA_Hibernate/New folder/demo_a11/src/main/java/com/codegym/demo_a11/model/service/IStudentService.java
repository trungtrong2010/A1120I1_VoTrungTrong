package com.codegym.demo_a11.model.service;

import com.codegym.demo_a11.model.entity.Student;


import java.util.List;

public interface IStudentService {
    void save(Student student);
    List<Student> findAll();
    Student findById(Integer id);
}
