package repository;

import model.Accident;
import model.AccidentType;
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

    public static List<AccidentType> getTypes() {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Type-1"));
        types.add(AccidentType.of(2, "Type-2"));
        types.add(AccidentType.of(3, "Type-3"));

        return types;
    }

    public static HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }
}
