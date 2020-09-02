package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUI {

    @Autowired
    private Store store;

    private Input input;

    @Autowired
    public void setInput(Input input) {
        this.input = input;
    }

    public void input() {
        for (String s : input.consoleInput()) {
            store.add(s);
        }

    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }

}
