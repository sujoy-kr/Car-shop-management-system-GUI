package carShop;

public class Sports extends Car {
    // Additional properties specific to Sports cars
    private final int horsepower;
    private final int topSpeed;
    private final double acceleration0to60;

    public Sports(String makeParam, String modelParam, int yearParam, int priceParam,
                  int horsepowerParam, int topSpeedParam, double acceleration0to60Param) {
        super(makeParam, modelParam, yearParam, priceParam);
        this.horsepower = horsepowerParam;
        this.topSpeed = topSpeedParam;
        this.acceleration0to60 = acceleration0to60Param;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public boolean isHyperCar() {
        return topSpeed >= 400 && acceleration0to60 <= 3.0;
    }


    public double getAcceleration0to60() {
        return acceleration0to60;
    }

    @Override
    public String displayCarInfo() {
        return "Make: " + getMake() + " | " +
                "Model: " + getModel() + " | " +
                "Year: " + getYear() + " | " +
                "Price: $" + getPrice() + " | " +
                "Horsepower: " + getHorsepower() + " HP | " +
                "Top Speed: " + getTopSpeed() + " KM/H | " +
                "0-60 KM/H Acceleration: " + getAcceleration0to60() + " seconds | " +
                "Is Hyper Car: " + (isHyperCar() ? "Yes" : "No");
    }


    @Override
    public double calculateResaleValue(int years) {
        double depreciationRate = 0.1; // because sports cars in general are kept well maintained
        return getPrice() * Math.pow(1 - depreciationRate, years);
    }
}
