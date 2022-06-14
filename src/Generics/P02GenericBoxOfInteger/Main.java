package Generics.P02GenericBoxOfInteger;

import Generics.P01GenericBox.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Box<Integer> integerBox = new Box<>(Integer.parseInt(scanner.nextLine()));
            System.out.print(integerBox);

        }
    }

}
