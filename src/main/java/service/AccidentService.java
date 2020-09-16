package service;

import model.Accident;
import model.Rule;
import model.Type;
import org.springframework.stereotype.Service;
import repository.AccidentRepository;
import repository.RuleRepository;
import repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService {
    private AccidentRepository accidents;
    private RuleRepository rules;
    private TypeRepository types;

    public AccidentService(AccidentRepository accidents, RuleRepository rules, TypeRepository types) {
        this.accidents = accidents;
        this.rules = rules;
        this.types = types;
    }

    public Accident saveAccident(Accident accident) {
        return accidents.save(accident);
    }

    public List<Accident> getAllAccidents() {
        List<Accident> accident = new ArrayList<>();
        accidents.findAll().forEach(accident::add);
        return accident;
    }

    public List<Rule> getAllRules() {
        List<Rule> rule = new ArrayList<>();
        rules.findAll().forEach(rule::add);
        return rule;
    }

    public List<Type> getAllTypes() {
        List<Type> type = new ArrayList<>();
        types.findAll().forEach(type::add);
        return type;
    }

    public Accident accidentById(int id) {
        return accidents.findById(id).get();
    }

    public Rule ruleById(int id) {
        return rules.findById(id).get();
    }
}
