package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        int low = bounds[0];
        int upper = bounds[1];

        System.out.println(IntStream.rangeClosed(low, upper)
                .boxed().filter(getPredicate(command))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    public static Predicate<Integer> getPredicate(String command) {
        if (command.equals("odd")) {
            return n -> n % 2 != 0;
        }
        return n -> n % 2 == 0;
    }

}
