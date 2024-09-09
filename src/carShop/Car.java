package carShop;

public abstract class Car {
    private final String make;
    private final String model;
    private final int year;
    private int price;

    public Car(String makeParam, String modelParam, int yearParam, int priceParam) {
        make = makeParam;
        model = modelParam;
        year = yearParam;
        price = priceParam;
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public abstract String displayCarInfo();
}
