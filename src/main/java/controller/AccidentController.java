package controller;

import model.Accident;
import model.Rule;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AccidentJdbcTemplate;
import repository.AccidentMem;

import java.util.Arrays;

@Controller
public class AccidentController {
    private final AccidentJdbcTemplate jdbc;

    public AccidentController(AccidentJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", jdbc.getAllTypes());
        model.addAttribute("rules", jdbc.getAllRules());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        jdbc.save(accident);
        return "redirect:/accidents";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("rules", jdbc.getAllRules());
        model.addAttribute("types", jdbc.getAllTypes());
        model.addAttribute("accident", jdbc.accidentById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        System.out.println(accident.getId() + "!!!!!!!!!!!!");
        jdbc.updateAccident(accident);
        return "redirect:/accidents";
    }

}
