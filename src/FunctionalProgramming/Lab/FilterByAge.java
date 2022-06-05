package FunctionalProgramming.Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> readPerson(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = filterByAge(people, getPredicate(condition, age));

        Consumer<Person> printer = getPrinter(format);

        people.forEach(printer);
    }

    public static Person readPerson(Scanner scanner) {
        String[] data = scanner.nextLine().split(", ");

        String name = data[0];
        int age = Integer.parseInt(data[1]);

        return new Person(name, age);
    }

    private static Consumer<Person> getPrinter(String format) {
        switch (format) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format " + format);
        }
    }

    private static Predicate<Person> getPredicate(String condition, int age) {
        switch (condition) {
            case "younger":
                return p -> p.age <= age;
            case "older":
                return p -> p.age >= age;
            default:
                throw new IllegalArgumentException("Invalid parameters for age predicate " + condition + " " + age);
        }
    }

    public static List<Person> filterByAge(List<Person> people, Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}