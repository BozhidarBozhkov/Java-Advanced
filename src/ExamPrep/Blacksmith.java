package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(carbonStack::push);

        Map<String, Integer> forgedSowrds = new TreeMap<>();
        forgedSowrds.put("Gladius", 0);
        forgedSowrds.put("Shamshir", 0);
        forgedSowrds.put("Katana", 0);
        forgedSowrds.put("Sabre", 0);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            //int firstSteel = steelQueue.poll();
            int lastCarbon = carbonStack.pop();

            int sum = lastCarbon + steelQueue.poll();
            String forgedSword;
            switch (sum) {
                case 70:
                    forgedSword = "Gladius";
                    break;
                case 80:
                    forgedSword = "Shamshir";
                    break;
                case 90:
                    forgedSword = "Katana";
                    break;
                case 110:
                    forgedSword = "Sabre";
                    break;
                default:
                    forgedSword = null;
                    break;
            }
            if (forgedSword != null) {
                forgedSowrds.put(forgedSword, forgedSowrds.get(forgedSword) + 1);
            } else {
                carbonStack.push(lastCarbon + 5);
            }

        }
        int swordsCount = forgedSowrds.values().stream().mapToInt(Integer::intValue).sum();
        if (swordsCount > 0) {
            System.out.printf("You have forged %d swords.%n", swordsCount);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        String steelLeft = steelQueue.isEmpty() ? "none" : steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Steel left: " + steelLeft);

        String carbonLeft = carbonStack.isEmpty() ? "none" : carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Carbon left: " + carbonLeft);

        forgedSowrds.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

}
