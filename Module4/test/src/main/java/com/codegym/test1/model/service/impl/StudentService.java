package com.codegym.test1.model.service.impl;

import com.codegym.test1.model.entity.Student;
import com.codegym.test1.model.repository.IStudentRepository;
import com.codegym.test1.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public List<Student> findAll() {
        return this.iStudentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return this.iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        this.iStudentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return this.iStudentRepository.findAllByNameContaining(name);
    }
}
