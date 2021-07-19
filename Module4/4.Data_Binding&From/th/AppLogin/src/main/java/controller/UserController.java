package controller;

import model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.UserRepository;

@Controller
public class UserController {


    @GetMapping(value = {"", "/login"})
    private String showFormLogin(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/checkLogin")
    private String checkLogin(@ModelAttribute("login") Login login, Model model) {
        if (UserRepository.checkLogin(login) != null) {
            model.addAttribute("user", UserRepository.checkLogin(login));
        } else{
            model.addAttribute("login", login);
            model.addAttribute("message","Not find ");
        }
        return "checkLogin";
    }
}
