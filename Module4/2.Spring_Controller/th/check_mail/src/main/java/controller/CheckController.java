package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Pattern;

@Controller
public class CheckController {

    /* Khai báo Regex Email*/
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping(value = {"", "email"})
    private String showForm() {
        return "checkMail";
    }

    private boolean validateEmail(String regex) {
        return Pattern.compile(EMAIL_REGEX).matcher(regex).matches();
    }

    @PostMapping("/check")
    private String checkEmail(@RequestParam("email") String email, Model model) {
        boolean check = validateEmail(email);
        if (check) {
            model.addAttribute("message", "right");
        } else model.addAttribute("message", "wrong");
        model.addAttribute("email", email);
        return "checkMail";
    }
}
