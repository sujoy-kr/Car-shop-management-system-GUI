package carShop.vehicles;

public class Sports extends Car {
    // Additional properties specific to Sports cars
    private final int horsepower;
    private final int topSpeed;
    private final double acceleration0to60;

    public Sports(String makeParam, String modelParam, int yearParam, int priceParam,
                  int horsepowerParam, int topSpeedParam, double acceleration0to60Param) {
        super(makeParam, modelParam, yearParam, priceParam);
        horsepower = horsepowerParam;
        topSpeed = topSpeedParam;
        acceleration0to60 = acceleration0to60Param;
    }

    // getters
    public int getHorsepower() {
        return horsepower;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public double getAcceleration0to60() {
        return acceleration0to60;
    }

    public boolean isHyperCar() {
        return topSpeed >= 400 && acceleration0to60 <= 3.0;
    }

    // Methods for JUnit testing
    public double calculateQuarterMileTime() {
        if (horsepower <= 0) return Double.MAX_VALUE;
        return 14.0 / (horsepower / 200.0) + acceleration0to60;
    }
    
    public boolean isTrackReady() {
        return horsepower > 300 && topSpeed > 250;
    }
    
    public double estimateAnnualMaintenanceCost(int milesDriven) {
        double baseCost = 1000.0;
        double costPerMile = 0.5;
        if (horsepower > 500) {
            baseCost *= 1.5;
            costPerMile = 1.0;
        }
        return baseCost + (milesDriven * costPerMile);
    }
    
    public boolean beatsInDragRace(Sports opponent) {
        if (opponent == null) return true;
        return this.calculateQuarterMileTime() < opponent.calculateQuarterMileTime();
    }

    // polymorphism override
    @Override
    public String displayCarInfo() {
        return "Make: " + getMake() + " | " +
                "Model: " + getModel() + " | " +
                "Year: " + getYear() + " | " +
                "Price: " + getPrice() + " Taka | " +
                "Horsepower: " + getHorsepower() + " HP | " +
                "Top Speed: " + getTopSpeed() + " KM/H | " +
                "0-60 KM/H Acceleration: " + getAcceleration0to60() + " seconds | " +
                "Is Hyper Car: " + (isHyperCar() ? "✓" : "✗") +
                (isTrackReady() ? " | Track Ready: ✓" : "");
    }
}
