package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsString = scanner.nextLine().split(", ");
        Function<String, Integer> parse = Integer::parseInt;
        List<Integer> numbers = Arrays.stream(numbersAsString).map(parse)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("Sum = " + sum);


    }

}
