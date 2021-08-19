package com.codegym.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class LoginController {

    public static HashMap<Integer,String> genders;
    static {
        genders = new HashMap<>();
        genders.put(0,"Female");
        genders.put(1,"Male");
        genders.put(2,"LGBT");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return "layout";
    }
}
