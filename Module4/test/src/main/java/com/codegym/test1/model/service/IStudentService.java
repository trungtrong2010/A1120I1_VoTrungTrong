package com.codegym.test1.model.service;

import com.codegym.test1.model.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);

    List<Student> findByName(String name);

}
