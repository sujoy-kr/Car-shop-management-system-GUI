package carShop;

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

    @Override
    public String displayCarInfo() {
        return "Make: " + getMake() + " | " +
                "Model: " + getModel() + " | " +
                "Year: " + getYear() + " | " +
                "Price: $" + getPrice() + " | " +
                "Fuel Efficiency: " + getFuelEfficiency() + " KMPL | " +
                "Seating Capacity: " + getSeatingCapacity() + " persons | " +
                "Trunk Space: " + getTrunkSpace() + " cubic feet | " +
                "Family Friendly: " + (isFamilyFriendly() ? "Yes" : "No");
    }
}
