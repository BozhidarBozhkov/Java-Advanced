package Generics.P07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box1<String> box1List = new Box1<>();

        String tokens;
        while (!"END".equals(tokens = scanner.nextLine())) {
            String[] token = tokens.split("\\s+");
            switch (token[0]) {
                case "Add":
                    box1List.add(token[1]);
                    break;
                case "Remove":
                    box1List.remove(Integer.parseInt(token[1]));
                    break;
                case "Contains":
                    System.out.println(box1List.contains(token[1]));
                    break;
                case "Swap":
                    box1List.swap(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Greater":
                    System.out.println(box1List.countGreaterThan(token[1]));
                    break;
                case "Max":
                    System.out.println(box1List.getMax());
                    break;
                case "Min":
                    System.out.println(box1List.getMin());
                    break;
                case "Print":
                    System.out.println(box1List);
                    break;
            }
        }
    }

}
