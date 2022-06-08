package DefiningClasses.Constructors;

public class Car {
    private String brand;
    private String model = "unknown";
    private int horsePower = -1;

    public Car(String brand) {
        this.brand = brand;
    }
    

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }


    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsePower());

    }

    @Override
    public String toString() {
        return carInfo();
    }
}

