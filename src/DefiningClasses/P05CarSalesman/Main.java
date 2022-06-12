package DefiningClasses.P05CarSalesman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Engine engine = null;
        List<Engine> engines = new ArrayList<>();

        while (n-- > 0) {
            String[] engineData = scanner.nextLine().split("\\s+");
//            String engineModel = engineData[0];
//            String enginePower = engineData[1];
//            String displacement = engineData[2];
//            String efficiency = engineData[3];

            switch (engineData.length) {
                case 2 :
                    engine = new Engine(engineData[0], engineData[1]);
                    break;
                case 3:
                    if (isNumber(engineData[2])) {
                        engine = new Engine(engineData[0], engineData[1], engineData[2], "n/a");
                    } else {
                        engine = new Engine(engineData[0], engineData[1], "n/a", engineData[2]);
                    }
                    break;
                default:
                    engine = new Engine(engineData[0], engineData[1], String.valueOf(engineData[2]), engineData[3]);
            }
            engines.add(engine);

        }
        int m = Integer.parseInt(scanner.nextLine());
        Car car = null;
        List<Car> cars = new LinkedList<>();
        while (m-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
//            String model = carData[0];
//            String carEngine = carData[1];
//            String weight = carData[2];
//            String color = carData[3];

            Engine currentEngine = null;
            for (Engine engine1 : engines) {
                if (engine1.getModel().equals(carData[1])) {
                    currentEngine = engine1;
                    break;
                }
            }
            switch (carData.length) {
                case 2:
                    car = new Car(carData[0], currentEngine);
                    break;
                case 3:
                    if (isNumber(carData[2])) {
                        car = new Car(carData[0], currentEngine, carData[2], "n/a");
                    } else {
                        car = new Car(carData[0], currentEngine, "n/a", carData[2]);
                    }
                    break;
                default:
                    car = new Car(carData[0], currentEngine, String.valueOf(carData[2]), carData[3]);

            }
            cars.add(car);

        }
        cars.forEach(System.out::println);
    }
    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
