package SetsAndMaps.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, String> phonebook = new HashMap<>();
        while (!line.equals("search")) {
            String[] contact = line.split("-");
            String name = contact[0];
            String phoneNumber = contact[1];

            phonebook.put(name, phoneNumber);

            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("stop")) {
            if (!phonebook.containsKey(line)) {
                System.out.printf("Contact %s does not exist.%n", line);
            } else {
                System.out.printf("%s -> %s%n", line, phonebook.get(line));
            }


            line = scanner.nextLine();
        }
    }

}
