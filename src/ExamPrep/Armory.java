package ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class Armory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        int rO = -1;
        int cO = -1;

        int[][] mirrors = new int[2][2];
        int mRow = 0;

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = String.valueOf(line.charAt(col));
                if (line.charAt(col) == 'A') {
                    rO = row;
                    cO = col;
                }
                if (line.charAt(col) == 'M') {
                    mirrors[mRow ][0] = row;
                    mirrors[mRow ][1] = col;
                    mRow ++;
                }
            }
        }
        int gold = 0;

        while (gold < 65) {
            String direction = scanner.nextLine();
            int oldRO = rO;
            int oldCO = cO;

            switch (direction) {
                case "up":
                    rO -= 1;
                    break;
                case "down":
                    rO += 1;
                    break;
                case "right":
                    cO += 1;
                    break;
                case "left":
                    cO -= 1;
                    break;
            }

            matrix[oldRO][oldCO] = "-";

            if(inTheMatrix(rO, cO, n, n)){

                if(matrix[rO][cO].matches("\\d")){
                    gold += Integer.parseInt(matrix[rO][cO]);
                }

                if(matrix[rO][cO].equals("M")){
                    if(rO == mirrors[0][0] && cO == mirrors[0][1]){
                        rO = mirrors[1][0];
                        cO = mirrors[1][1];
                        matrix[mirrors[0][0]][mirrors[0][1]] = "-";
                    } else {
                        rO = mirrors[0][0];
                        cO = mirrors[0][1];
                        matrix[mirrors[1][0]][mirrors[1][1]] = "-";
                    }
                }
                matrix[rO][cO] = "A";
            } else break;
        }

        if(inTheMatrix(rO, cO, n, n)){
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.%n",gold);
        Arrays.stream(matrix).forEach(s -> {Arrays.stream(s).forEach(System.out::print);System.out.println();});

    }

    private static boolean inTheMatrix(int row, int col, int rowMatrix, int colMatrix) {
        return row >= 0 && row <= rowMatrix - 1 && col >= 0 && col <= colMatrix - 1;
    }

}
