package carShop;

import java.util.ArrayList;

public class CarShop {
    private ArrayList<Car> inventory;
    private ArrayList<Customer> customers;

    public CarShop() {
        inventory = new ArrayList<Car>();
        customers = new ArrayList<Customer>();
    }

    public void addCarToInventory(Car car) {
        inventory.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String printAllCars() {
        StringBuilder carDetails = new StringBuilder();
        for (Car car : inventory) {
            carDetails.append(car.displayCarInfo()).append("\n\n");
        }
        return carDetails.toString();
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
