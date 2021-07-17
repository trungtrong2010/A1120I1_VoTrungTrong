package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageHomeController {

    @GetMapping(value = {"","/home"})
    private String showForm() {
        return "form";
    }

    @PostMapping("/home2")
    private String showResult(@RequestParam("usd") Double usd, Model model) {
        model.addAttribute("VNd", usd * 25000);
        return "form";
    }
}
