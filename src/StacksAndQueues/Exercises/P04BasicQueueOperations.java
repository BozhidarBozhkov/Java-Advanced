import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        int elementsToOffer = Integer.parseInt(line[0]);
        int elementsToRemove = Integer.parseInt(line[1]);
        int elementToSearch = Integer.parseInt(line[2]);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elementsToOffer; i++) {
            queue.offer(elements[i]);
        }
        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }
        if (queue.contains(elementToSearch)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }

    }

}
