package carShop;

import java.util.ArrayList;

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
}
