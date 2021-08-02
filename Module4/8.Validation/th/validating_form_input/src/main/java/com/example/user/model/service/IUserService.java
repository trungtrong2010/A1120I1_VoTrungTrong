package com.example.user.model.service;

import com.example.user.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void save(User user);
}
