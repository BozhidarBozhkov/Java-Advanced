    package MultidimensionalArrays.Exercises;
    
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;
    
    public class P07Crossfire {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
    
            int rows = size[0];
            int cols = size[1];
    
            List<List<Integer>> matrix = new ArrayList<>();
            int counter = 1;
            for (int row = 0; row < rows; row++) {
                matrix.add(new ArrayList<>());
                for (int col = 0; col < cols; col++) {
                    matrix.get(row).add(counter);
                    counter++;
                }
            }
    
            String input = scanner.nextLine();
    
            while (!input.equals("Nuke it from orbit")) {
                String[] coordinates = input.split("\\s+");
                int rowTarget = Integer.parseInt(coordinates[0]);
                int colTarget = Integer.parseInt(coordinates[1]);
                int radius = Integer.parseInt(coordinates[2]);
    
                destroyElements(matrix, rowTarget, colTarget, radius);
                for (int i = 0; i < matrix.size(); i++) {
                    if (matrix.get(i).size() == 0) {
                        matrix.remove(i--);
                    }
                }
    
                input = scanner.nextLine();
            }
            for (int row = 0; row < matrix.size(); row++) {
                for (int col = 0; col < matrix.get(row).size(); col++) {
                    System.out.print(matrix.get(row).get(col) + " ");
                }
                System.out.println();
            }
        }
    
        private static void destroyElements(List<List<Integer>> matrix, int rowTarget, int colTarget, int radius) {
            for (int i = colTarget + radius; i >= colTarget - radius; i--) {
                    if (isValidIndex(rowTarget, matrix.size()) && isValidIndex(i, matrix.get(rowTarget).size())) {
                        matrix.get(rowTarget).remove(i);
                    }
            }
            for (int i = rowTarget - radius; i <= rowTarget + radius; i++) {
                if (isValidIndex(i, matrix.size()) && isValidIndex(colTarget, matrix.get(i).size()) && i != rowTarget) {
                    matrix.get(i).remove(colTarget);
                }
            }
        }
    
        private static boolean isValidIndex(int i, int size) {
            return i >= 0 && i < size;
        }
    
    }
