package SetsAndMaps.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countryWithCities = map.get(continent);
            countryWithCities.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countryWithCities.get(country);
            cities.add(city);
        }
        map.entrySet().forEach(entry -> {
            String continent = entry.getKey();
            Map<String, List<String>> countryWithCities = entry.getValue();

            System.out.println(continent + ":");

            countryWithCities.entrySet().forEach(country -> {
                System.out.println("  " + country.getKey() + " -> " + String.join(", ", country.getValue()));
            });
        });
    }

}
