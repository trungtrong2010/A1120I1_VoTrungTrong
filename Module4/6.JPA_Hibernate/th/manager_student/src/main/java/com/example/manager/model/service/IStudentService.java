package com.example.manager.model.service;

import com.example.manager.model.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);

    List<Student> findByName(String name);

}
