package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> smallestInt = (int[] arr) -> {
            int min = Integer.MAX_VALUE;
            for (int n  : arr) {
                if(n < min){
                    min = n;
                }
            }
            return min;
        };

        System.out.println(smallestInt.apply(numbers));

    }
    public static Integer smallestInt(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int n : arr) {
            if(n < min){
                min = n;
            }
        }
        return min;
    }
}
