package di;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(Input.class);
        context.reg(StartUI.class);

        StartUI startUI = context.get(StartUI.class);

        startUI.input();

        startUI.print();
    }
}
