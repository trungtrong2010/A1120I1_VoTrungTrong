package com.example.register.service;

import com.example.register.dao.UserRepository;
import com.example.register.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user){
            userRepository.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        List<User> list = this.selectAllUser();
        List<String> listEmail = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listEmail.add(list.get(i).getEmail());
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
