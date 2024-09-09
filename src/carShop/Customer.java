package carShop;

import java.util.ArrayList;

public class Customer implements User {
    private String name;
    private String address;
    private String contactInfo;
    private final ArrayList<Car> purchasedCars;

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

    // polymorphism override
    @Override
    public String getUserInfo() {
        String userInfo = "Name: " + getName() + "\n\n" +
                "Address: " + getAddress() + "\n\n" +
                "Contact Info: " + getContactInfo() + "\n\n" +
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
