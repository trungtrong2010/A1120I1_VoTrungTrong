package com.example.security.model.service.impl;

import com.example.security.model.entity.User;
import com.example.security.model.repository.IUserRepository;
import com.example.security.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

}
