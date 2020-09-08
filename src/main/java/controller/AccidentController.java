package controller;

import model.Accident;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AccidentMem;

@Controller
public class AccidentController {

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        AccidentMem.addAccident(accident.getId(), accident);
        return "redirect:/accidents";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", AccidentMem.getAccidents().get(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        AccidentMem.addAccident(accident.getId(), accident);
        return "redirect:/accidents";
    }
}
