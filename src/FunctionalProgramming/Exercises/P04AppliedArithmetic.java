package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        UnaryOperator<List<Integer>> addFunction = numbersList -> numbersList.stream().map(el -> el + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyFunction = numbersList -> numbersList.stream().map(el -> el * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractFunction = numbersList -> numbersList.stream().map(el -> el - 1).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addFunction.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(number -> System.out.printf("%d ", number));
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}