package carShop.vehicles;

public abstract class Car {
    private final String make;
    private final String model;
    private final int year;
    private final int price;

    public Car(String makeParam, String modelParam, int yearParam, int priceParam) {
        if (priceParam < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
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

    // Methods for JUnit testing
    public double calculateDepreciation(int currentYear, double ratePerYear) {
        if (currentYear <= year) return price;
        if (ratePerYear < 0 || ratePerYear > 1) throw new IllegalArgumentException("Rate must be between 0 and 1");
        int yearsOld = currentYear - year;
        double currentPrice = price * Math.pow((1 - ratePerYear), yearsOld);
        return Math.max(currentPrice, 0.0);
    }

    public boolean isAntique(int currentYear) {
        return (currentYear - year) >= 25;
    }
    
    public double estimateInsurance(int driverAge) {
        double baseRate = price * 0.05;
        if (driverAge < 25) {
            baseRate *= 1.5;
        } else if (driverAge > 65) {
            baseRate *= 1.2;
        }
        return baseRate;
    }

    public boolean isSameMake(Car otherCar) {
        if (otherCar == null) return false;
        return this.make.equalsIgnoreCase(otherCar.getMake());
    }

    // abstract method
    public abstract String displayCarInfo();
}
