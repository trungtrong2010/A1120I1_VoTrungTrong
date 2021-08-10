package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User setUpUser() {
        return new User();
    }

    @GetMapping("/login")
    public String showFormLogin(@CookieValue(name = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    public String login(@ModelAttribute(name = "user") User user, Model model, @CookieValue(name = "setUser", defaultValue = "") String setUser,
                        HttpServletResponse response, HttpServletRequest request) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            if (user.getUsername() != null) {
                setUser = user.getUsername();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(2);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", cookie1);
                    break;
                } else {
                    cookie1.setValue("");
                    model.addAttribute("cookieValue", cookie1);
                    break;
                }
            }
            model.addAttribute("message", "Login success ! WELCOME");
        } else {
            user.setUsername("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed ! Try again!");
        }
        return "login";
    }
}
