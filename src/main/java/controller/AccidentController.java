package controller;

import model.Accident;
import model.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AccidentMem;

import java.util.Arrays;

@Controller
public class AccidentController {

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", AccidentMem.getTypes());
        model.addAttribute("rules", AccidentMem.getRules());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident,
                       @RequestParam("ruleIds") String[] ruleIds) {
        Arrays.asList(ruleIds).stream().forEach(r
                -> accident.addRule(Rule.of(Integer.valueOf(r), "")));
        AccidentMem.addAccident(accident.getId(), accident);
        return "redirect:/accidents";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("rules", AccidentMem.getRules());
        model.addAttribute("types", AccidentMem.getTypes());
        model.addAttribute("accident", AccidentMem.getAccidents().get(id));
        return "update";
    }
}
