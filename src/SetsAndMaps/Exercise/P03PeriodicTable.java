package SetsAndMaps.Exercise;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" ");
            Collections.addAll(elementSet, elements);
        }
        System.out.println(String.join(" ", elementSet));
    }

}
