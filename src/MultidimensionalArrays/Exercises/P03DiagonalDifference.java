package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int counter = 0; counter < n; counter++) {
            primaryDiagonalSum += matrix[counter][counter];
        }
        for (int row = 0, col = n - 1; row < n && col >= 0; row++, col--) {
            secondaryDiagonalSum += matrix[row][col];
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

}
