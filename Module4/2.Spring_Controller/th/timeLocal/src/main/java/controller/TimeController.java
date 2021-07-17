package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeController {

    @GetMapping(value = {"", "/time"})
    private String showForm() {
        return "homepage";
    }
}
