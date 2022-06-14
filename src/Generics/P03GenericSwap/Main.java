package Generics.P03GenericSwap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        while (n-- > 0) {
            String element = scanner.nextLine();
            box.add(element);
        }
        String[] swap = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(swap[0]);
        int secondIndex = Integer.parseInt(swap[1]);

        box.swap(firstIndex, secondIndex);
        System.out.println(box);
    }

}
