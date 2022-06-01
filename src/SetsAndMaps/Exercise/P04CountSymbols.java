package SetsAndMaps.Exercise;

import java.util.*;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                if (!symbols.containsKey(current)) {
                    symbols.put(current, 1);
                } else {
                    int currentCount = symbols.get(current);
                    symbols.put(current, ++currentCount);
                }
        }
        //S: 1 time/s
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }

}
