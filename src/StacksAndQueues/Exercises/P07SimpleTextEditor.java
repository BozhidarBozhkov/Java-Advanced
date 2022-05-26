package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String commandType = tokens[0];

            switch (commandType) {
                case "1":
                    commands.push(input);
                    executeAdd(tokens[1], text);
                    break;
                case "2":
                    commands.push(input);
                    int countToDelete = Integer.parseInt(tokens[1]);
                    StringBuilder sb = new StringBuilder();
                    for (int j = text.length() - countToDelete; j < text.length(); j++) {
                        sb.append(text.charAt(j));
                    }
                    removedElements.push(sb.toString());
                    executeDelete(countToDelete, text);
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.printf("%s%n", text.charAt(index - 1));
                    break;
                case "4":
                   String lastCommand = commands.pop();
                   String[] lastCommandArguments = lastCommand.split(" ");
                   String lastCommandType = lastCommandArguments[0];
                   switch (lastCommandType) {
                       case "1":
                           int elementsToDelete = lastCommandArguments[1].length();
                           executeDelete(elementsToDelete, text);
                           break;
                       case "2":
                           String elementsToAddBack = removedElements.pop();
                           executeAdd(elementsToAddBack, text);
                           break;
                   }
                    break;
            }

        }
    }

    private static void executeDelete(int countToDelete, StringBuilder text) {
        int textLength = text.length();
        for (int i = 0; i < countToDelete ; i++) {
            text.deleteCharAt(text.length() - 1);
        }
    }

    private static void executeAdd(String tokens, StringBuilder sb) {
        sb.append(tokens);
    }

}
