//package com.example.security.config;
//
//import com.example.security.model.entity.User;
//import com.example.security.model.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//
//import java.util.ArrayList;
//
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private IUserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = this.userService.findByUsername(username);
//        UserDetails userDetails = User.withUsername
//        return null;
//    }
//
//}
