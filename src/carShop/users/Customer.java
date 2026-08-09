package carShop.users;

import java.util.ArrayList;
import carShop.vehicles.Car;

public class Customer implements User {
    private String name;
    private String address;
    private String contactInfo;
    private ArrayList<Car> purchasedCars;

    public Customer() {
        name = null;
        address = null;
        contactInfo = null;
        purchasedCars = new ArrayList<>();
    }

    // setters
    public void setName(String nameParam) {
        name = nameParam;
    }

    public void setAddress(String addressParam) {
        address = addressParam;
    }

    public void setContactInfo(String contactInfoParam) {
        contactInfo = contactInfoParam;
    }

    public void setPurchasedCarsEmpty() {
        purchasedCars = new ArrayList<>();
    }

    public void updatePurchasedCars(Car carToAdd) {
        purchasedCars.add(carToAdd);
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    // Methods for JUnit testing
    public ArrayList<Car> getPurchasedCars() {
        return purchasedCars;
    }
    
    public int getTotalSpent() {
        int total = 0;
        for (Car car : purchasedCars) {
            total += car.getPrice();
        }
        return total;
    }

    public boolean isVIP() {
        return getTotalSpent() >= 5000000;
    }
    
    public Car getMostExpensivePurchase() {
        if (purchasedCars.isEmpty()) return null;
        Car maxCar = purchasedCars.get(0);
        for (Car car : purchasedCars) {
            if (car.getPrice() > maxCar.getPrice()) {
                maxCar = car;
            }
        }
        return maxCar;
    }
    
    public boolean hasBoughtMake(String make) {
        if (make == null) return false;
        for (Car car : purchasedCars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                return true;
            }
        }
        return false;
    }
    
    public int getPurchaseCountByYear(int year) {
        int count = 0;
        for (Car car : purchasedCars) {
            if (car.getYear() == year) {
                count++;
            }
        }
        return count;
    }

    // polymorphism override
    @Override
    public String getUserInfo() {
        String userInfo = "Name: " + getName() + "\n\n" +
                "Address: " + getAddress() + "\n\n" +
                "Contact Info: " + getContactInfo() + "\n\n" +
                "VIP Status: " + (isVIP() ? "Yes" : "No") + "\n\n" +
                "Total Spent: " + getTotalSpent() + " Taka\n\n" +
                "Purchased Cars:\n\n";

        if (purchasedCars.isEmpty()) {
            userInfo += "No cars purchased yet.\n";
        } else {
            for (Car car : purchasedCars) {
                userInfo += car.displayCarInfo() + "\n\n";
            }
        }

        return userInfo;
    }
}
