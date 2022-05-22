import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")) {
            String task = input;
            if (!task.equals("cancel")){
                queue.offer(task);
            }
            if (task.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.pollFirst());
                }
            }
            input = scanner.nextLine();
        }
        while (!queue.isEmpty()) {
            String output = queue.pollFirst();
            System.out.println(output);
        }
    }

}
