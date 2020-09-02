package di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("di");
        context.refresh();

        StartUI startUI = context.getBean(StartUI.class);
        startUI.input();
        startUI.print();
    }
}
