package di;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public List<String> consoleInput() {
        List<String> data = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные:");
            String nl = scanner.nextLine();
            if (nl.equals("stop")) {
                break;
            }
            data.add(nl);
        }
        return data;
    }
}
