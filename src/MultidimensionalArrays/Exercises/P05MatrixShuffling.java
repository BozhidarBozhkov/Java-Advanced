package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }

            if (!input[0].equals("swap") || input.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(input[1]);
            int col1 = Integer.parseInt(input[2]);
            int row2 = Integer.parseInt(input[3]);
            int col2 = Integer.parseInt(input[4]);

            if (indexIsValid(row1, rows) || indexIsValid(col1, cols) || indexIsValid(row2, rows)
                    || indexIsValid(col2, cols)) {
                System.out.println("Invalid input!");
                continue;
            }
            swapElements(matrix, row1, col1, row2, col2);
            printMatrix(matrix);
        }
    }

    private static boolean indexIsValid(int i, int max) {
        return i < 0 || i >= max;
    }

    private static void printMatrix(String[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(cell -> sb.append(String.format("%s ", cell)));
            System.out.println(sb);
        });
    }

    private static void swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

}
