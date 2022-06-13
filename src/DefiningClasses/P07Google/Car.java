package DefiningClasses.P07Google;

public class Car {
    private String carModel;
    private int speed;

    public Car(String carModel, int speed) {
        this.carModel = carModel;
        this.speed = speed;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", getCarModel(), getSpeed());
    }
}
