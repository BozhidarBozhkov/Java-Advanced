package SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> productMap = new TreeMap<>();

        String line;

        while (!"Revision".equals(line = scanner.nextLine())) {

            String[] input = line.split(", ");
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            productMap.putIfAbsent(shop, new LinkedHashMap<>());
            productMap.get(shop).put(product, price);

        }

        productMap.forEach((key, value) -> {
            System.out.println(key + "->");
            value.forEach((key1, value1) -> System.out.println(String.format("Product: %s, Price: %.1f", key1, value1)));
        });

    }
}
