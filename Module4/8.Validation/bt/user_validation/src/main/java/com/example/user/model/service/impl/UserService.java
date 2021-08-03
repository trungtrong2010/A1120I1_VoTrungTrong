package com.example.user.model.service.impl;

import com.example.user.model.entity.User;
import com.example.user.model.repository.IUserRepository;
import com.example.user.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public Page<User> findByNameContaining(String name, Pageable pageable) {
        return this.userRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<User> findByNameContainingAndTypeUser_Id(String name, int idTypeUser, Pageable pageable) {
        return this.userRepository.findByNameContainingAndTypeUser_Id(name, idTypeUser, pageable);
    }

    @Override
    public Page<User> findByTypeUser_Id(int id, Pageable pageable) {
        return this.userRepository.findByTypeUser_Id(id, pageable);
    }
}
