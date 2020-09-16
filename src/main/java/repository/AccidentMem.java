package repository;

import model.Accident;
import model.Type;
import model.Rule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem {
    private static HashMap<Integer, Accident> accidents = new HashMap<>();

    public static void addAccident(Integer id, Accident accident) {
        accidents.put(id, accident);
    }

    public static List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(Rule.of(1, "Rule-1"));
        rules.add(Rule.of(2, "Rule-2"));
        rules.add(Rule.of(3, "Rule-3"));

        return rules;
    }

    public static List<Type> getTypes() {
        List<Type> types = new ArrayList<>();
        types.add(Type.of(1, "Type-1"));
        types.add(Type.of(2, "Type-2"));
        types.add(Type.of(3, "Type-3"));

        return types;
    }

    public static HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }
}
