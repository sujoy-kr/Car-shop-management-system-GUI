package carShop.inventory;

import java.util.ArrayList;
import carShop.vehicles.Car;

public class CarShop {
    private final ArrayList<Car> inventory;

    public CarShop() {
        inventory = new ArrayList<>();
    }

    public void addCarToInventory(Car car) {
        inventory.add(car);
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }

    // Methods for JUnit testing
    public int getTotalInventoryValue() {
        int total = 0;
        for (Car car : inventory) {
            total += car.getPrice();
        }
        return total;
    }

    public ArrayList<Car> findCarsByMake(String make) {
        ArrayList<Car> result = new ArrayList<>();
        if (make == null || make.isEmpty()) return result;
        for (Car car : inventory) {
            if (car.getMake().equalsIgnoreCase(make)) {
                result.add(car);
            }
        }
        return result;
    }

    public Car getMostExpensiveCar() {
        if (inventory.isEmpty()) return null;
        Car maxCar = inventory.get(0);
        for (Car car : inventory) {
            if (car.getPrice() > maxCar.getPrice()) {
                maxCar = car;
            }
        }
        return maxCar;
    }

    public Car getCheapestCar() {
        if (inventory.isEmpty()) return null;
        Car minCar = inventory.get(0);
        for (Car car : inventory) {
            if (car.getPrice() < minCar.getPrice()) {
                minCar = car;
            }
        }
        return minCar;
    }

    public boolean removeCar(Car car) {
        return inventory.remove(car);
    }

    public double getAveragePrice() {
        if (inventory.isEmpty()) return 0.0;
        return (double) getTotalInventoryValue() / inventory.size();
    }
}
