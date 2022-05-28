package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();

        String input = scanner.nextLine();

        List<String> wordList = new ArrayList<>();
        int maxColLength = Integer.MIN_VALUE;
        while (!input.equals("END")) {
            int currLength = input.length();

            if (currLength > maxColLength) {
                maxColLength = currLength;
            }
            wordList.add(input);

            input = scanner.nextLine();
        }
        //create the matrix
        int rows = wordList.size();
        int cols = maxColLength;

        char[][] matrix = new char[rows][cols];
        // fill the matrix
        for (int row = 0; row < rows; row++) {
            String currentWord = wordList.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentSymbol = currentWord.charAt(col);
                    matrix[row][col] = currentSymbol;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        String angleStr = rotation.split("[()]")[1];
        int angle = Integer.parseInt(angleStr);
        int angleOfRot = angle % 360;

        printMatrix(rows, cols, matrix, angleOfRot);
    }

    private static void printMatrix(int rows, int cols, char[][] matrix, int angleOfRot) {
        switch (angleOfRot) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1 ; row >= 0 ; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0 ; row--) {
                    for (int col = cols - 1 ; col >= 0 ; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

}
