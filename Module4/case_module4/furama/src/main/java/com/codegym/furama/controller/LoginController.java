package com.codegym.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "layout";
    }
}
