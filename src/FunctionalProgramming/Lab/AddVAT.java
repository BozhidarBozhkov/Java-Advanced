package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] prices = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices).map(Double::parseDouble)
                .map(addVat)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }

}
