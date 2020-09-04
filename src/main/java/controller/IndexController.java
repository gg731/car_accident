package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/user")
    public String index(Model model) {
        List<String> firsts = new ArrayList<>();
        firsts.add("FirstName-1");
        firsts.add("FirstName-2");
        firsts.add("FirstName-3");

        model.addAttribute("firsts", firsts);
        return "index";
    }
}
