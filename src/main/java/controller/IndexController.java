package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.AccidentMem;

@Controller
public class IndexController {

    @GetMapping("/accidents")
    public String index(Model model) {

        model.addAttribute("accidents", AccidentMem.getAccidents().values());
        return "index";
    }
}
