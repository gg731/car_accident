package controller;

import model.Accident;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.AccidentMem;

@Controller
public class IndexController {

    @GetMapping("/accidents")
    public String index(Model model) {
        AccidentMem.addAccident(1, new Accident(1, "Accident-1", "Text-1", "Address-1"));
        AccidentMem.addAccident(2, new Accident(2, "Accident-2", "Text-2", "Address-2"));
        AccidentMem.addAccident(3, new Accident(3, "Accident-3", "Text-3", "Address-3"));

        model.addAttribute("accidents", AccidentMem.getAccidents().values());
        return "index";
    }
}
