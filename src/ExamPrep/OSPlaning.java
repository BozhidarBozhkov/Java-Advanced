package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputOne = scanner.nextLine();
        String inputTwo = scanner.nextLine();

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();


        Arrays.stream(inputOne.split(", ")).map(Integer::parseInt)
                .forEach(tasks::push);
        Arrays.stream(inputTwo.split(" ")).map(Integer::parseInt)
                .forEach(threads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {
            if (tasks.peek() == taskToKill) {
                System.out.println("Thread with value " + threads.peek() + " killed task " + taskToKill);
                break;
            } else if (threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }
        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

}
