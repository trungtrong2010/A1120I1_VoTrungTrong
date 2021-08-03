package com.example.user.model.service;

import com.example.user.model.entity.TypeUser;

import java.util.List;

public interface ITypeUserService {
    List<TypeUser> findAll();

    TypeUser findById(int id);
}
