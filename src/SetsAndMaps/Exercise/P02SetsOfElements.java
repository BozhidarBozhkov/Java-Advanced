package SetsAndMaps.Exercise;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        int first = Integer.parseInt(data[0]);
        int second = Integer.parseInt(data[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        readNumbers(scanner, first, firstSet);
        Set<String> secondSet = new LinkedHashSet<>();
        readNumbers(scanner, second, secondSet);

        firstSet.retainAll(secondSet);
        System.out.println(String.join(" ", firstSet));
    }

    private static void readNumbers(Scanner scanner, int n, Set<String> numberSet) {
        for (int i = 0; i < n; i++) {
            numberSet.add(scanner.nextLine());
        }
    }

}
