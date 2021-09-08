package com.codegym.furama.model.service;

import com.codegym.furama.model.entity.user.UserRole;

import java.util.List;

public interface IUserRoleService {

    List<UserRole> findAll();

    UserRole findById(int id);

    void save(UserRole userRole);

    void delete(UserRole userRole);
}
