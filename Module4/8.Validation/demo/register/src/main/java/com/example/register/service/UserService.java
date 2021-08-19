package com.example.register.service;

import com.example.register.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();
    User findByEmail(String email);
    void saveUser(User user);

    boolean checkEmail(String email);
}
