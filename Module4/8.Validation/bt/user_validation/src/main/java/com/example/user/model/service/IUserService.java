package com.example.user.model.service;

import com.example.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    Page<User> findAll(Pageable pageable);

    User findById(int id);

    void save(User user);

    void remove(User user);

    Page<User> findByNameContaining(String name, Pageable pageable);

    Page<User> findByNameContainingAndTypeUser_Id(String name, int idTypeUser, Pageable pageable);

    Page<User> findByTypeUser_Id(int id, Pageable pageable);
}
