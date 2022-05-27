package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        String[][] matrix = new String[rows][cols];

        createMatrix(rows, cols, matrix);
        printMatrix(rows, cols, matrix);
    }

    private static void createMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String current = "a";
            for (int col = 0; col < cols; col++) {
                char outside = (char) ('a' + row);
                char middle = (char) ('a' + col + row);
                matrix[row][col] = "" + outside + middle + outside;
                // matrix[row][col] = String.valueOf(outside) + middle + outside;
            }
        }
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
