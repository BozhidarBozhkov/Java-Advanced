package SetsAndMaps.Lab;

import java.util.*;

public class AverageStudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] studentData = scanner.nextLine().split(" ");
            String studentName = studentData[0];
            Double grade = Double.parseDouble(studentData[1]);

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
            }
            students.get(studentName).add(grade);
        }
        for (var entry : students.entrySet()) {
            String key = entry.getKey();
            System.out.print(key + " -> ");
            entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));
            List<Double> values = entry.getValue();
            double sum = 0;
            for (Double value : values) {
                sum += value;
            }
            System.out.printf("(avg: %.2f)%n", sum/ values.size());
        }
    }

}
