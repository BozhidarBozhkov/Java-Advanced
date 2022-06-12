package DefiningClasses.P02CompanyRooster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<Employee> employees = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String department = info[3];
            Employee employee = null;
            switch (info.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (info[4].matches("\\d+")) {
                        int age = Integer.parseInt(info[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = info[4];
                        employee = new Employee(name, salary, position, department, email);

                    }
                    break;
                case 6:
                    String email = info[4];
                    int age = Integer.parseInt(info[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
            }
            boolean departmentExists = departmentList.stream()
                    .filter(d -> d.getName().equals(department)).count() >= 1;
            if (!departmentExists) {
                departmentList.add(new Department(department));
            }
            Department currentDpmt = departmentList.stream().filter(d -> d.getName().equals(department))
                    .findFirst().get();
            currentDpmt.getEmployees().add(employee);
        }
        Department highestPaidDepartment = departmentList.stream()
                .max(Comparator.comparingDouble(d -> d.calcAverageSalary())).get();
        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }

}
