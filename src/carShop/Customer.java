package carShop;

import java.util.ArrayList;

public class Customer implements User {
    private String name;
    private String address;
    private String contactInfo;
    private ArrayList<Car> purchasedCars;

    public Customer() {
        name = null;
        address = null;
        contactInfo = null;
        purchasedCars = new ArrayList<Car>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public ArrayList<Car> getPurchasedCars() {
        return purchasedCars;
    }

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

    @Override
    public String getUserInfo() {
        String userInfo = "Name: " + getName() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Contact Info: " + getContactInfo() + "\n" +
                "Purchased Cars:\n";

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
