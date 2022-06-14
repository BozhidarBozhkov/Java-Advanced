package Generics.P04SwapInteger;

import Generics.P03GenericSwap.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();
        while (n-- > 0) {
            int element = Integer.parseInt(scanner.nextLine());
            box.add(element);
        }
        String[] swap = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(swap[0]);
        int secondIndex = Integer.parseInt(swap[1]);

        box.swap(firstIndex, secondIndex);
        System.out.println(box);
    }

}
