package com.example.user.model.service.impl;

import com.example.user.model.entity.User;
import com.example.user.model.repository.UserRepository;
import com.example.user.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}
