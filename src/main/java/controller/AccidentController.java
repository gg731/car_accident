package controller;

import model.Accident;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AccidentRepository;
import service.AccidentService;

import java.util.Arrays;

@Controller
public class AccidentController {
    private final AccidentService service;

    public AccidentController(AccidentService accidents) {
        this.service = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", service.getAllTypes());
        model.addAttribute("rules", service.getAllRules());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam("ruleIds") int[] ids) {
        Arrays.stream(ids).forEach(id -> accident.addRule(service.ruleById(id)));
        service.saveAccident(accident);
        return "redirect:/accidents";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("rules", service.getAllRules());
        model.addAttribute("types", service.getAllTypes());
        model.addAttribute("accident", service.accidentById(id));
        return "update";
    }
}
