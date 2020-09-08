package repository;

import model.Accident;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AccidentMem {
    private static HashMap<Integer, Accident> accidents = new HashMap<>();

    public static void addAccident(Integer id, Accident accident) {
        accidents.put(id, accident);
    }

    public static HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }

}
