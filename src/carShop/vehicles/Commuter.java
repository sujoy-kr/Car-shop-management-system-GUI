package carShop.vehicles;

public class Commuter extends Car {
    private final double fuelEfficiency;
    private final int seatingCapacity;
    private final double trunkSpace; // liters

    public Commuter(String makeParam, String modelParam, int yearParam, int priceParam,
                    double fuelEfficiencyParam, int seatingCapacityParam, double trunkSpaceParam) {
        super(makeParam, modelParam, yearParam, priceParam);
        fuelEfficiency = fuelEfficiencyParam;
        seatingCapacity = seatingCapacityParam;
        trunkSpace = trunkSpaceParam;
    }

    // getters
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public double getTrunkSpace() {
        return trunkSpace;
    }

    public boolean isFamilyFriendly() {
        return seatingCapacity >= 5 && trunkSpace >= 15.0;
    }

    // Methods for JUnit testing
    public double calculateTravelCost(double distanceKm, double fuelPricePerLiter) {
        if (fuelEfficiency <= 0) return -1.0;
        double litersNeeded = distanceKm / fuelEfficiency;
        return litersNeeded * fuelPricePerLiter;
    }
    
    public boolean canFitLuggage(double totalLuggageVolume) {
        return totalLuggageVolume <= trunkSpace;
    }
    
    public boolean isHighlyEfficient() {
        return fuelEfficiency >= 20.0;
    }
    
    public int maxPassengersIncludingDriver() {
        return seatingCapacity;
    }

    // polymorphism override
    @Override
    public String displayCarInfo() {
        return "Make: " + getMake() + " | " +
                "Model: " + getModel() + " | " +
                "Year: " + getYear() + " | " +
                "Price: " + getPrice() + " Taka | " +
                "Fuel Efficiency: " + getFuelEfficiency() + " KMPL | " +
                "Seating Capacity: " + getSeatingCapacity() + " persons | " +
                "Trunk Space: " + getTrunkSpace() + " cubic feet | " +
                "Family Friendly: " + (isFamilyFriendly() ? "✓" : "✗");
    }
}
