package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value = {"", "/sandwich"})
    private String getSandwich() {
        return "sandwich";
    }

    @PostMapping("/choice")
    private String save(@RequestParam("condiment") String condiment, Model model) {
        List<String> condimentList = new ArrayList<>();
        condimentList.add(condiment);
        model.addAttribute("condimentList", condimentList);
        return "showChoice";
    }
}
