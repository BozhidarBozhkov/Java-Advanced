package DefiningClasses.P07Google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personInfo = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] personData = input.split(" ");
            String name = personData[0];
            String token = personData[1];
            Company company = null;
            Pokemon pokemon = null;
            Parents parents = null;
            Children children = null;
            Car car = null;

            personInfo.putIfAbsent(name, new Person(name, company, new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>(), car));

            switch (token) {
                case "company":
                    String companyName = personData[2];
                    String department = personData[3];
                    double salary = Double.parseDouble(personData[4]);
                    company = new Company(companyName, department, salary);
                    personInfo.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = personData[2];
                    String pokemonType = personData[3];
                    pokemon = new Pokemon(pokemonName, pokemonType);
                    personInfo.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = personData[2];
                    String birthday = personData[3];
                    parents = new Parents(parentName, birthday);
                    personInfo.get(name).getParents().add(parents);
                    break;
                case "children":
                    String childName = personData[2];
                    String childBirthday = personData[3];
                    children = new Children(childName, childBirthday);
                    personInfo.get(name).getChildren().add(children);
                    break;
                case "car":
                    String model = personData[2];
                    int speed = Integer.parseInt(personData[3]);
                    car = new Car(model, speed);
                    personInfo.get(name).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        System.out.println(input);
        for (Map.Entry<String, Person> personEntry : personInfo.entrySet()) {
            if (personEntry.getKey().equals(input)) {
                System.out.println("Company:");
                if (personEntry.getValue().getCompany() != null) {
                    System.out.println(personEntry.getValue().getCompany());
                }
                System.out.println("Car:");
                if (personEntry.getValue().getCar() != null) {
                    System.out.println(personEntry.getValue().getCar());
                }
                System.out.println("Pokemon:");
                if (personEntry.getValue().getPokemons() != null) {
                    personEntry.getValue().getPokemons().forEach(System.out::println);
                }
                System.out.println("Parents:");
                if (personEntry.getValue().getParents() != null) {
                    personEntry.getValue().getParents().forEach(System.out::println);
                }
                System.out.println("Children:");
                if (personEntry.getValue().getChildren() != null) {
                    personEntry.getValue().getChildren().forEach(System.out::println);
                }
            }
        }
    }

}
