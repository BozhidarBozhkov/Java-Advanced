package SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }
        while (!input.equals("END")) {
            vip.remove(input);
            regular.remove(input);

            input = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        for (String guest : vip) {
            System.out.println(guest);
        }
        for (String guest : regular) {
            System.out.println(guest);
        }
    }

}
