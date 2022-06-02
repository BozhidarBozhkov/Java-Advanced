package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> emailsMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emailsMap.put(name, email);
            }
            input = scanner.nextLine();
        }
        emailsMap.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

    }

}
