package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).filter(n -> n % 2 != 1).collect(Collectors.toList());

        String output = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);

        Collections.sort(numbers);
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }

}
