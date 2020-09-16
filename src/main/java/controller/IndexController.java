package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.AccidentService;

@Controller
public class IndexController {
    private final AccidentService service;

    public IndexController(AccidentService accidents) {
        this.service = accidents;
    }

    @GetMapping("/accidents")
    public String index(Model model) {
        model.addAttribute("accidents", service.getAllAccidents());
        return "index";
    }
}
