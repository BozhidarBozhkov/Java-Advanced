package SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vehicles = new LinkedHashSet<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                String[] tokens = input.split(", ");
                String direction = tokens[0];
                String regNumber = tokens[1];
                if (direction.equals("IN")) {
                    vehicles.add(regNumber);
                } else {
                    vehicles.remove(regNumber);
                }
            }
        }
        if (vehicles.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

}
