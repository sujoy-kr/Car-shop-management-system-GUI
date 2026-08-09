package carShop.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import carShop.vehicles.Car;
import carShop.vehicles.Commuter;
import carShop.vehicles.Sports;

public class CarShopTest {

    private CarShop shop;
    private Commuter commuter1;
    private Commuter commuter2;
    private Sports sports1;

    @BeforeEach
    public void setUp() {
        shop = new CarShop();
        commuter1 = new Commuter("Toyota", "Corolla", 2020, 2500000, 15.0, 5, 470.0);
        commuter2 = new Commuter("Honda", "Civic", 2021, 2800000, 14.5, 5, 450.0);
        sports1 = new Sports("Porsche", "911", 2022, 15000000, 450, 310, 3.2);

        shop.addCarToInventory(commuter1);
        shop.addCarToInventory(commuter2);
        shop.addCarToInventory(sports1);
    }

    @Test
    public void testGetTotalInventoryValue() {
        int expectedTotal = 2500000 + 2800000 + 15000000;
        assertEquals(expectedTotal, shop.getTotalInventoryValue(), "Total inventory value should match sum of all cars.");
    }

    @Test
    public void testFindCarsByMake() {
        ArrayList<Car> foundCars = shop.findCarsByMake("Honda");
        assertEquals(1, foundCars.size(), "Should find exactly 1 Honda.");
        assertEquals("Honda", foundCars.get(0).getMake(), "The found car make should be Honda.");

        ArrayList<Car> noCars = shop.findCarsByMake("Ferrari");
        assertTrue(noCars.isEmpty(), "Should return empty list for make not in inventory.");
    }

    @Test
    public void testGetMostExpensiveCar() {
        Car mostExp = shop.getMostExpensiveCar();
        assertNotNull(mostExp);
        assertEquals("Porsche", mostExp.getMake(), "Porsche should be the most expensive car.");
        assertEquals(15000000, mostExp.getPrice());
    }

    @Test
    public void testGetCheapestCar() {
        Car cheapest = shop.getCheapestCar();
        assertNotNull(cheapest);
        assertEquals("Toyota", cheapest.getMake(), "Toyota should be the cheapest car.");
        assertEquals(2500000, cheapest.getPrice());
    }

    @Test
    public void testRemoveCar() {
        boolean removed = shop.removeCar(commuter1);
        assertTrue(removed, "Car should be successfully removed.");
        assertEquals(2, shop.getInventory().size(), "Inventory size should decrease by 1.");
    }

    @Test
    public void testGetAveragePrice() {
        int expectedTotal = 2500000 + 2800000 + 15000000;
        double expectedAverage = expectedTotal / 3.0;
        assertEquals(expectedAverage, shop.getAveragePrice(), 0.01, "Average price should be total value divided by size.");
    }

    @Test
    public void testEmptyShopOperations() {
        CarShop emptyShop = new CarShop();
        assertEquals(0, emptyShop.getTotalInventoryValue());
        assertEquals(0.0, emptyShop.getAveragePrice());
        assertNull(emptyShop.getMostExpensiveCar());
        assertNull(emptyShop.getCheapestCar());
    }
}
