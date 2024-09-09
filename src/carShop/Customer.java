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

    public Customer(String nameParam, String addressParam, String contactInfoParam) {
        name = nameParam;
        address = addressParam;
        contactInfo = contactInfoParam;
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
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("Name: ").append(getName()).append("\n")
                .append("Address: ").append(getAddress()).append("\n")
                .append("Contact Info: ").append(getContactInfo()).append("\n")
                .append("Purchased Cars:\n");

        if (purchasedCars.isEmpty()) {
            userInfo.append("No cars purchased yet.\n");
        } else {
            for (Car car : purchasedCars) {
                userInfo.append(car.displayCarInfo()).append("\n\n");
            }
        }

        return userInfo.toString();
    }

}
