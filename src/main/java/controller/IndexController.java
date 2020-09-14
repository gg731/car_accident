package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.AccidentHbn;

@Controller
public class IndexController {
    private final AccidentHbn accidents;

    public IndexController(AccidentHbn accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/accidents")
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAllAccident());
        return "index";
    }
}
