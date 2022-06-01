package SetsAndMaps.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> graduation = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] gradesList = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[gradesList.length];
            for (int j = 0; j < gradesList.length; j++) {
                grades[j] = Double.parseDouble(gradesList[j]);
            }
            graduation.put(name, grades);
        }
        String pattern = "#.###################################";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (Map.Entry<String, Double[]> entry : graduation.entrySet()) {
            double avg = 0;
            for (double v : entry.getValue()) {
                avg += v;
            }
            avg /= entry.getValue().length;

            System.out.printf("%s is graduated with %s%n", entry.getKey(), decimalFormat.format(avg));
        }
    }

}
