package com.example.security.model.service;

import com.example.security.model.entity.User;

public interface IUserService {
    User findByUsername(String username);
}
