package SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> mapNumber = new LinkedHashMap<>();

        for (double n: numbers) {
            if (!mapNumber.containsKey(n)) {
                mapNumber.put(n, 1);
            } else {
                mapNumber.put(n, mapNumber.get(n) + 1);
            }
        }
        for (double key: mapNumber.keySet()) {
            System.out.printf("%.1f -> %d%n", key, mapNumber.get(key));
        }
    }

}
