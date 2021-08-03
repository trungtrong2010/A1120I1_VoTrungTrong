package com.example.user.model.service.impl;

import com.example.user.model.entity.TypeUser;
import com.example.user.model.repository.ITypeUserRepository;
import com.example.user.model.service.ITypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeUserService implements ITypeUserService {

    @Autowired
    private ITypeUserRepository typeUserRepository;

    @Override
    public List<TypeUser> findAll() {
        return this.typeUserRepository.findAll();
    }

    @Override
    public TypeUser findById(int id) {
        return this.typeUserRepository.findById(id).orElse(null);
    }
}
