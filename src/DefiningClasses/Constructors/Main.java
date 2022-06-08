package DefiningClasses.Constructors;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //Set<Car> cars = new HashSet<>();

        while (n-- > 0) {
            String[] carData = scanner.nextLine().split(" ");
            String brand = carData[0];

            Car car;
            if (carData.length == 1) {
                car = new Car(brand);
            } else {
                String model = carData[1];
                int hp = Integer.parseInt(carData[2]);
                car = new Car(brand, model, hp);
            }
            System.out.println(car.carInfo());
        }
    }

}
