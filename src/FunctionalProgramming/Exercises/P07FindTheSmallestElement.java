package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementIndex = integerList -> {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < integerList.size(); i++) {
                if (integerList.get(i) <= min) {
                    min = integerList.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };
        System.out.println(minElementIndex.apply(numbers));
    }
    public static Integer minElementIndex(List<Integer> list) {
        int minElement = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) <= minElement){
                minElement = list.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

}
