package di;

public class StartUI {

    private Store store;

    private Input input;

    public StartUI(Store store, Input input) {
        this.store = store;
        this.input = input;
    }

    public void input(){
        for (String s : input.consoleInput()){
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
