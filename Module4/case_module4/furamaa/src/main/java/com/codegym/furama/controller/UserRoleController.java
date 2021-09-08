package com.codegym.furama.controller;

import com.codegym.furama.model.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserRoleController {

    @Autowired
    private IUserRoleService userRoleService;


}
