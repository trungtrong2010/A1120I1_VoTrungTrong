package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping(value = {"", "/calculator"})
    private String getForm() {
        return "calculator";
    }

    @PostMapping("/showResult")
    private String calculator(@RequestParam("calculator") String calculator, @RequestParam("number1") double number1, @RequestParam("number2") double number2, Model model) {
        double result = 0;
        switch (calculator) {
            case "Addition(+)":
                result = number1 + number2;
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                break;
            case "Multiptication(x)":
                result = number1 * number2;
                break;
            case "Division(/)":
                if (number2 != 0) {
                    result = number1 / number2;

                } else model.addAttribute("message", "Error division number2 = 0");
                break;
            default:
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("calculator", calculator);
        model.addAttribute("result", result);
        return "calculator";
    }
}
