package carShop.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import carShop.vehicles.Car;
import carShop.vehicles.Commuter;
import carShop.vehicles.Sports;

public class CustomerTest {

    private Customer customer;
    private Commuter commuter1;
    private Sports sports1;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
        customer.setName("John Doe");

        commuter1 = new Commuter("Toyota", "Corolla", 2020, 2500000, 15.0, 5, 470.0);
        sports1 = new Sports("Porsche", "911", 2022, 15000000, 450, 310, 3.2);
    }

    @Test
    public void testGetTotalSpent() {
        assertEquals(0, customer.getTotalSpent(), "Initial spent amount should be 0.");
        
        customer.updatePurchasedCars(commuter1);
        assertEquals(2500000, customer.getTotalSpent(), "Total spent should equal the price of commuter1.");
        
        customer.updatePurchasedCars(sports1);
        assertEquals(17500000, customer.getTotalSpent(), "Total spent should equal sum of all purchased cars.");
    }

    @Test
    public void testIsVIP() {
        assertFalse(customer.isVIP(), "Customer with 0 spent should not be VIP.");
        
        customer.updatePurchasedCars(commuter1); // 2,500,000
        assertFalse(customer.isVIP(), "Customer with 2,500,000 spent should not be VIP.");
        
        customer.updatePurchasedCars(sports1); // + 15,000,000
        assertTrue(customer.isVIP(), "Customer with 17,500,000 spent should be VIP.");
    }

    @Test
    public void testGetMostExpensivePurchase() {
        assertNull(customer.getMostExpensivePurchase(), "Should return null if no cars purchased.");
        
        customer.updatePurchasedCars(commuter1);
        customer.updatePurchasedCars(sports1);
        
        Car mostExp = customer.getMostExpensivePurchase();
        assertEquals("Porsche", mostExp.getMake(), "Most expensive purchase should be Porsche.");
    }

    @Test
    public void testHasBoughtMake() {
        customer.updatePurchasedCars(commuter1);
        assertTrue(customer.hasBoughtMake("Toyota"), "Should return true for purchased make.");
        assertTrue(customer.hasBoughtMake("toyota"), "Make check should be case-insensitive.");
        assertFalse(customer.hasBoughtMake("Honda"), "Should return false for unpurchased make.");
    }

    @Test
    public void testGetPurchaseCountByYear() {
        customer.updatePurchasedCars(commuter1); // year 2020
        customer.updatePurchasedCars(new Commuter("Honda", "Civic", 2020, 2000000, 14, 5, 400));
        customer.updatePurchasedCars(sports1); // year 2022
        
        assertEquals(2, customer.getPurchaseCountByYear(2020), "Should find 2 cars from 2020.");
        assertEquals(1, customer.getPurchaseCountByYear(2022), "Should find 1 car from 2022.");
        assertEquals(0, customer.getPurchaseCountByYear(2024), "Should find 0 cars from 2024.");
    }
}
