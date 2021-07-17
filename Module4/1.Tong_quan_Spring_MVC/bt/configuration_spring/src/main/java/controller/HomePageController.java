package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomePageController {

    @GetMapping(value = {"", "/homepgae"})
    private String showPage() {
        return "homepage";
    }

    @PostMapping("/translate")
    private String translate(@RequestParam("english") String english, Model model) {
        String vietnamese;
        switch (english) {
            case "dog":
                vietnamese = "chó";
                break;
            case "cat":
                vietnamese = "mèo";
                break;
            case "book":
                vietnamese = "sách";
                break;
            default:
                vietnamese = "cat , dog and book";
        }
        model.addAttribute("vietnamese", vietnamese);
        return "homepage";
    }
}
