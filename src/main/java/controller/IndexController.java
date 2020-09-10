package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.AccidentJdbcTemplate;

@Controller
public class IndexController {
    private final AccidentJdbcTemplate jdbcTemplate;

    public IndexController(AccidentJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/accidents")
    public String index(Model model) {

        model.addAttribute("accidents", jdbcTemplate.getAllAccidents());
        return "index";
    }
}
