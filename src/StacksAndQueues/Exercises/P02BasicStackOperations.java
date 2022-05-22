import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementsToPush = elements[0];
        int elementsToRemove = elements[1];
        int elementToSearch = elements[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer n : numbers) {
            stack.push(n);
        }
        for (int i = 0; i < elementsToRemove; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(elementToSearch)){
            System.out.println("true");
        } else {
            //System.out.println(stack.stream().mapToInt(e->e).min().orElse(0));
            System.out.println(Collections.min(stack));
        }
    }

}
