package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")){
            fillMatrixPatternA(size, matrix);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(size, matrix);
        }

        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int size, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = size - 1; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int size, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

}
