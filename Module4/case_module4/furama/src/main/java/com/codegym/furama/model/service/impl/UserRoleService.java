package com.codegym.furama.model.service.impl;

import com.codegym.furama.model.entity.user.UserRole;
import com.codegym.furama.model.repository.user.IUserRoleRepository;
import com.codegym.furama.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return this.userRoleRepository.findAll();
    }

    @Override
    public UserRole findById(int id) {
        return this.userRoleRepository.findById(id).orElse(null);
    }

    @Override
    public void save(UserRole userRole) {
        this.userRoleRepository.save(userRole);
    }

    @Override
    public void delete(UserRole userRole) {
        this.userRoleRepository.delete(userRole);
    }
}
