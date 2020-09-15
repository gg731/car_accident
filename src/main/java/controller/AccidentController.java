package controller;

import model.Accident;
import model.AccidentType;
import model.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.AccidentHbn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AccidentController {
    private final AccidentHbn accidents;

    public AccidentController(AccidentHbn accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getAllType());
        model.addAttribute("rules", accidents.getAllRule());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam("ruleIds") int[] ids) {
        Arrays.stream(ids).forEach(id -> accident.addRule(accidents.ruleById(id)));
        accidents.saveAccident(accident);
        return "redirect:/accidents";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("rules", accidents.getAllRule());
        model.addAttribute("types", accidents.getAllType());
        model.addAttribute("accident", accidents.accidentById(id));
        return "update";
    }

//    @PostMapping("/update")
//    public String update(
//            @ModelAttribute Accident accident) {
//
////        accident.setType(accidents.typeById(type));
//        System.out.println(accident.getName() + " !!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        accidents.saveAccident(accident);
//
//        System.out.println(accident.getName() + " !!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//        return "redirect:/accidents";
//    }
}
