package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        Predicate<String> checkUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> capitalWords = Arrays.stream(words).filter(checkUpperCase)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
//        for (String capitalWord : capitalWords) {
//            System.out.println(capitalWord);
//        }
        capitalWords.forEach(System.out::println);

    }

}
