package carShop;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import carShop.inventory.CarShop;
import carShop.users.Customer;
import carShop.vehicles.Car;
import carShop.vehicles.Commuter;
import carShop.vehicles.Sports;

public class Main {

    // Define UI Constants
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 28);
    private static final Font LABEL_FONT = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font INPUT_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185); // Blue
    private static final Color SUCCESS_COLOR = new Color(39, 174, 96); // Green
    private static final Color DANGER_COLOR = new Color(231, 76, 60); // Red
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color BG_COLOR = new Color(245, 247, 250);

    // Session State
    private static boolean isUserLoggedIn = false;
    private static Customer currentCustomer = null;
    private static final List<Customer> allCustomers = new ArrayList<>();

    public static void main(String[] args) {

        // Set Nimbus Look and Feel for a modern look
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Fallback to default if Nimbus is unavailable
        }

        CarShop shop = new CarShop();
        
        // Add default cars (Seed Data)
        shop.addCarToInventory(new Commuter("Toyota", "Corolla", 2020, 2500000, 15.0, 5, 470.0));
        shop.addCarToInventory(new Commuter("Honda", "Civic", 2021, 2800000, 14.5, 5, 450.0));
        shop.addCarToInventory(new Sports("Porsche", "911", 2022, 15000000, 450, 310, 3.2));
        shop.addCarToInventory(new Sports("Ferrari", "F8 Tributo", 2023, 35000000, 710, 340, 2.9));

        // Create the main frame
        JFrame frame = new JFrame("Car Shop Management System");
        frame.setSize(1200, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(BG_COLOR);

        // Main panel using CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());
        mainPanel.setBackground(BG_COLOR);

        // ================= ADMIN PANEL =================
        JPanel adminPanel = new JPanel(new BorderLayout(0, 20));
        adminPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        adminPanel.setBackground(BG_COLOR);

        JLabel adminTitle = new JLabel("Admin Dashboard");
        adminTitle.setFont(TITLE_FONT);
        adminTitle.setForeground(TEXT_COLOR);
        adminTitle.setHorizontalAlignment(SwingConstants.CENTER);
        adminPanel.add(adminTitle, BorderLayout.NORTH);
        
        JPanel splitPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        splitPanel.setBackground(BG_COLOR);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(BG_COLOR);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(BG_COLOR);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(LABEL_FONT);

        // --- Commuter Car Panel ---
        JPanel commuterCarPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        commuterCarPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        commuterCarPanel.setBackground(Color.WHITE);

        JTextField commuterMakeInput = createStyledTextField();
        JTextField commuterModelInput = createStyledTextField();
        JTextField commuterYearInput = createStyledTextField();
        JTextField commuterPriceInput = createStyledTextField();
        JTextField fuelEfficiencyInput = createStyledTextField();
        JTextField seatingCapacityInput = createStyledTextField();
        JTextField trunkSpaceInput = createStyledTextField();

        addFormRow(commuterCarPanel, "Car Make:", commuterMakeInput);
        addFormRow(commuterCarPanel, "Car Model:", commuterModelInput);
        addFormRow(commuterCarPanel, "Car Year:", commuterYearInput);
        addFormRow(commuterCarPanel, "Car Price (Taka):", commuterPriceInput);
        addFormRow(commuterCarPanel, "Fuel Efficiency (KMPL):", fuelEfficiencyInput);
        addFormRow(commuterCarPanel, "Seating Capacity:", seatingCapacityInput);
        addFormRow(commuterCarPanel, "Trunk Space (Liters):", trunkSpaceInput);

        JButton addCommuterCarButton = createStyledButton("Add Commuter Car", PRIMARY_COLOR);
        commuterCarPanel.add(new JLabel()); // empty cell
        commuterCarPanel.add(addCommuterCarButton);

        // --- Sports Car Panel ---
        JPanel sportsCarPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        sportsCarPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        sportsCarPanel.setBackground(Color.WHITE);

        JTextField sportsMakeInput = createStyledTextField();
        JTextField sportsModelInput = createStyledTextField();
        JTextField sportsYearInput = createStyledTextField();
        JTextField sportsPriceInput = createStyledTextField();
        JTextField horsepowerInput = createStyledTextField();
        JTextField topSpeedInput = createStyledTextField();
        JTextField accelerationInput = createStyledTextField();

        addFormRow(sportsCarPanel, "Car Make:", sportsMakeInput);
        addFormRow(sportsCarPanel, "Car Model:", sportsModelInput);
        addFormRow(sportsCarPanel, "Car Year:", sportsYearInput);
        addFormRow(sportsCarPanel, "Car Price (Taka):", sportsPriceInput);
        addFormRow(sportsCarPanel, "Horsepower (HP):", horsepowerInput);
        addFormRow(sportsCarPanel, "Top Speed (KMPH):", topSpeedInput);
        addFormRow(sportsCarPanel, "0-60 KMPH (Seconds):", accelerationInput);

        JButton addSportsCarButton = createStyledButton("Add Sports Car", PRIMARY_COLOR);
        sportsCarPanel.add(new JLabel()); // empty cell
        sportsCarPanel.add(addSportsCarButton);

        tabbedPane.addTab("Add Commuter Car", commuterCarPanel);
        tabbedPane.addTab("Add Sports Car", sportsCarPanel);
        
        leftPanel.add(tabbedPane, BorderLayout.CENTER);
        splitPanel.add(leftPanel);

        // Output text areas in the right panel

        JTextArea shopStatsArea = new JTextArea(4, 30);
        styleTextArea(shopStatsArea);
        JScrollPane scrollPaneStats = new JScrollPane(shopStatsArea);
        JLabel shopStatsLabel = new JLabel("Shop Statistics:");
        shopStatsLabel.setFont(LABEL_FONT);
        shopStatsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(shopStatsLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        rightPanel.add(scrollPaneStats);
        
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextArea carListArea = new JTextArea(8, 30);
        styleTextArea(carListArea);
        JScrollPane scrollPane = new JScrollPane(carListArea);
        JLabel carListLabel = new JLabel("Current Inventory:");
        carListLabel.setFont(LABEL_FONT);
        carListLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(carListLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        rightPanel.add(scrollPane);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JTextArea userTextArea = new JTextArea(8, 30);
        styleTextArea(userTextArea);
        JScrollPane scrollPaneUser = new JScrollPane(userTextArea);
        JLabel userInfoLabel = new JLabel("Global User Logs:");
        userInfoLabel.setFont(LABEL_FONT);
        userInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(userInfoLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        rightPanel.add(scrollPaneUser);

        splitPanel.add(rightPanel);
        adminPanel.add(splitPanel, BorderLayout.CENTER);

        // Pre-fill areas
        updateShopStatsArea(shop, shopStatsArea);
        updateCarListArea(shop, carListArea);
        updateAdminUserLog(userTextArea);

        // ================= USER SIGNUP PANEL =================
        JPanel userSignupPanel = new JPanel();
        userSignupPanel.setLayout(new BoxLayout(userSignupPanel, BoxLayout.Y_AXIS));
        userSignupPanel.setBorder(new EmptyBorder(50, 200, 50, 200)); 
        userSignupPanel.setBackground(BG_COLOR);

        JLabel userSignupTitle = new JLabel("Create Your Profile");
        userSignupTitle.setFont(TITLE_FONT);
        userSignupTitle.setForeground(TEXT_COLOR);
        userSignupTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userSignupTitle);
        userSignupPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        JPanel signupFormPanel = new JPanel(new GridLayout(3, 2, 15, 20));
        signupFormPanel.setBackground(BG_COLOR);
        signupFormPanel.setMaximumSize(new Dimension(600, 150));

        JTextField userNameInput = createStyledTextField();
        JTextField userAddressInput = createStyledTextField();
        JTextField userContactInput = createStyledTextField();

        addFormRow(signupFormPanel, "Full Name:", userNameInput);
        addFormRow(signupFormPanel, "Delivery Address:", userAddressInput);
        addFormRow(signupFormPanel, "Contact Number:", userContactInput);

        userSignupPanel.add(signupFormPanel);
        userSignupPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        JButton signupButton = createStyledButton("Sign Up & Enter Shop", SUCCESS_COLOR);
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(signupButton);

        // ================= USER CAR LISTING PANEL =================
        JPanel userCarListWrapper = new JPanel(new BorderLayout());
        userCarListWrapper.setBackground(BG_COLOR);
        
        JPanel userCarListPanel = new JPanel();
        userCarListPanel.setLayout(new BoxLayout(userCarListPanel, BoxLayout.Y_AXIS));
        userCarListPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        userCarListPanel.setBackground(BG_COLOR);
        
        JScrollPane carListScrollPane = new JScrollPane(userCarListPanel);
        carListScrollPane.setBorder(null);
        userCarListWrapper.add(carListScrollPane, BorderLayout.CENTER);

        // Add panels to the main panel
        mainPanel.add(adminPanel, "adminPanel");
        mainPanel.add(userSignupPanel, "userSignupPanel");
        mainPanel.add(userCarListWrapper, "userCarListPanel");

        // Toggle Button panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        controlPanel.setBackground(Color.DARK_GRAY);
        controlPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        JButton toggleButton = createStyledButton("Switch to Admin Panel", Color.GRAY);
        toggleButton.setForeground(Color.WHITE);
        controlPanel.add(toggleButton);

        // Frame Layout Configuration
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "userSignupPanel");

        // Action Listeners
        toggleButton.addActionListener(new ActionListener() {
            boolean isAdmin = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAdmin) {
                    if (isUserLoggedIn) {
                        cl.show(mainPanel, "userCarListPanel");
                        renderUserShop(shop, frame, userCarListPanel, userTextArea, shopStatsArea, cl, mainPanel);
                    } else {
                        cl.show(mainPanel, "userSignupPanel");
                    }
                    toggleButton.setText("Switch to Admin Panel");
                } else {
                    cl.show(mainPanel, "adminPanel");
                    toggleButton.setText("Switch to User Panel");
                    updateShopStatsArea(shop, shopStatsArea);
                    updateCarListArea(shop, carListArea);
                    updateAdminUserLog(userTextArea);
                }
                isAdmin = !isAdmin;
            }
        });

        addCommuterCarButton.addActionListener(e -> {
            try {
                if (commuterMakeInput.getText().isEmpty() || commuterModelInput.getText().isEmpty()) {
                    throw new IllegalArgumentException("Fields cannot be empty!");
                }
                shop.addCarToInventory(new Commuter(
                        commuterMakeInput.getText(), commuterModelInput.getText(),
                        Integer.parseInt(commuterYearInput.getText()), Integer.parseInt(commuterPriceInput.getText()),
                        Double.parseDouble(fuelEfficiencyInput.getText()), Integer.parseInt(seatingCapacityInput.getText()),
                        Double.parseDouble(trunkSpaceInput.getText())
                ));
                updateShopStatsArea(shop, shopStatsArea);
                updateCarListArea(shop, carListArea);
                clearInputs(commuterMakeInput, commuterModelInput, commuterYearInput, commuterPriceInput, fuelEfficiencyInput, seatingCapacityInput, trunkSpaceInput);
                JOptionPane.showMessageDialog(frame, "Commuter car added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please check your numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        addSportsCarButton.addActionListener(e -> {
            try {
                if (sportsMakeInput.getText().isEmpty() || sportsModelInput.getText().isEmpty()) {
                    throw new IllegalArgumentException("Fields cannot be empty!");
                }
                shop.addCarToInventory(new Sports(
                        sportsMakeInput.getText(), sportsModelInput.getText(),
                        Integer.parseInt(sportsYearInput.getText()), Integer.parseInt(sportsPriceInput.getText()),
                        Integer.parseInt(horsepowerInput.getText()), Integer.parseInt(topSpeedInput.getText()),
                        Double.parseDouble(accelerationInput.getText())
                ));
                updateShopStatsArea(shop, shopStatsArea);
                updateCarListArea(shop, carListArea);
                clearInputs(sportsMakeInput, sportsModelInput, sportsYearInput, sportsPriceInput, horsepowerInput, topSpeedInput, accelerationInput);
                JOptionPane.showMessageDialog(frame, "Sports car added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please check your numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        signupButton.addActionListener(e -> {
            String userName = userNameInput.getText();
            String userAddress = userAddressInput.getText();
            String userContact = userContactInput.getText();

            if (!userName.isEmpty() && !userAddress.isEmpty() && !userContact.isEmpty()) {
                currentCustomer = new Customer();
                currentCustomer.setName(userName);
                currentCustomer.setAddress(userAddress);
                currentCustomer.setContactInfo(userContact);
                allCustomers.add(currentCustomer);
                isUserLoggedIn = true;

                updateAdminUserLog(userTextArea);

                clearInputs(userNameInput, userAddressInput, userContactInput);

                cl.show(mainPanel, "userCarListPanel");
                renderUserShop(shop, frame, userCarListPanel, userTextArea, shopStatsArea, cl, mainPanel);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields to proceed.", "Notice", JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    private static void renderUserShop(CarShop shop, JFrame frame, JPanel userCarListPanel, JTextArea userTextArea, JTextArea shopStatsArea, CardLayout cl, JPanel mainPanel) {
        userCarListPanel.removeAll();

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(BG_COLOR);
        
        JLabel shopTitle = new JLabel("Available Cars");
        shopTitle.setFont(TITLE_FONT);
        shopTitle.setForeground(TEXT_COLOR);
        headerPanel.add(shopTitle, BorderLayout.WEST);

        JButton logoutButton = createStyledButton("Log Out", DANGER_COLOR);
        logoutButton.addActionListener(e -> {
            isUserLoggedIn = false;
            currentCustomer = null;
            cl.show(mainPanel, "userSignupPanel");
            JOptionPane.showMessageDialog(frame, "You have successfully logged out.");
        });
        headerPanel.add(logoutButton, BorderLayout.EAST);
        
        headerPanel.setMaximumSize(new Dimension(800, 50));
        userCarListPanel.add(headerPanel);
        userCarListPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        if (shop.getInventory().isEmpty()) {
            JLabel noCarsLabel = new JLabel("No cars currently available in the shop.");
            noCarsLabel.setFont(LABEL_FONT);
            noCarsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            userCarListPanel.add(noCarsLabel);
        } else {
            for (Car car : shop.getInventory()) {
                JPanel carCard = new JPanel(new BorderLayout(15, 15));
                carCard.setBackground(Color.WHITE);
                carCard.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(220, 224, 229), 1, true),
                        new EmptyBorder(15, 15, 15, 15)
                ));
                carCard.setMaximumSize(new Dimension(1000, 350));

                String infoStr = car.displayCarInfo();
                String formattedInfo = infoStr.replace(" | ", "<br>");

                JLabel carLabel = new JLabel("<html><b>" + car.getMake() + " " + car.getModel() + "</b> (" + car.getYear() + ")<br>" +
                        "<div style='margin-top: 5px; color: #555;'>" + formattedInfo + "</div></html>");
                carLabel.setFont(INPUT_FONT);
                
                JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                actionPanel.setBackground(Color.WHITE);
                
                // --- Add Interactive Tools ---
                JButton estimateInsuranceBtn = createStyledButton("Estimate Insurance", new Color(142, 68, 173)); // Purple
                estimateInsuranceBtn.addActionListener(e2 -> {
                    String ageStr = JOptionPane.showInputDialog(frame, "Enter Driver Age to estimate insurance:");
                    try {
                        if (ageStr != null) {
                            int age = Integer.parseInt(ageStr);
                            double est = car.estimateInsurance(age);
                            JOptionPane.showMessageDialog(frame, "Estimated Annual Insurance: " + String.format("%.2f", est) + " Taka");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid Age!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                actionPanel.add(estimateInsuranceBtn);

                if (car instanceof Commuter) {
                    Commuter cCar = (Commuter) car;
                    JButton tripCostBtn = createStyledButton("Calculate Trip Cost", new Color(52, 152, 219)); // Light Blue
                    tripCostBtn.addActionListener(e2 -> {
                        try {
                            String distStr = JOptionPane.showInputDialog(frame, "Enter Distance (KM):");
                            if (distStr == null) return;
                            String priceStr = JOptionPane.showInputDialog(frame, "Enter Fuel Price per Liter (Taka):");
                            if (priceStr == null) return;
                            
                            double dist = Double.parseDouble(distStr);
                            double price = Double.parseDouble(priceStr);
                            double cost = cCar.calculateTravelCost(dist, price);
                            JOptionPane.showMessageDialog(frame, "Estimated Trip Cost: " + String.format("%.2f", cost) + " Taka");
                        } catch(Exception ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                    actionPanel.add(tripCostBtn);
                } else if (car instanceof Sports) {
                    Sports sCar = (Sports) car;
                    
                    JButton maintenanceBtn = createStyledButton("Maintenance Cost", new Color(46, 204, 113)); // Emerald Green
                    maintenanceBtn.addActionListener(e2 -> {
                        String milesStr = JOptionPane.showInputDialog(frame, "Enter Miles Driven per Year:");
                        try {
                            if (milesStr != null) {
                                int miles = Integer.parseInt(milesStr);
                                double cost = sCar.estimateAnnualMaintenanceCost(miles);
                                JOptionPane.showMessageDialog(frame, "Estimated Annual Maintenance Cost: " + String.format("%.2f", cost) + " Taka");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(frame, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                    actionPanel.add(maintenanceBtn);

                    JButton raceBtn = createStyledButton("1/4 Mile Time", new Color(211, 84, 0)); // Orange
                    raceBtn.addActionListener(e2 -> {
                        double time = sCar.calculateQuarterMileTime();
                        boolean trackReady = sCar.isTrackReady();
                        JOptionPane.showMessageDialog(frame, "Estimated 1/4 Mile Time: " + String.format("%.2f", time) + " seconds\n" +
                                "Track Ready: " + (trackReady ? "Yes" : "No"));
                    });
                    actionPanel.add(raceBtn);
                }
                
                JButton buyButton = createStyledButton("Purchase", SUCCESS_COLOR);
                buyButton.addActionListener(e1 -> {
                    currentCustomer.updatePurchasedCars(car);
                    updateAdminUserLog(userTextArea);
                    shop.removeCar(car); // Remove car from shop after purchase
                    updateShopStatsArea(shop, shopStatsArea);
                    
                    JOptionPane.showMessageDialog(frame, "Congratulations! You bought a " + car.getMake() + " " + car.getModel() + ".");
                    // refresh shop view
                    renderUserShop(shop, frame, userCarListPanel, userTextArea, shopStatsArea, cl, mainPanel);
                });

                actionPanel.add(buyButton);
                carCard.add(carLabel, BorderLayout.CENTER);
                carCard.add(actionPanel, BorderLayout.SOUTH);
                userCarListPanel.add(carCard);
                userCarListPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            }
        }
        userCarListPanel.revalidate();
        userCarListPanel.repaint();
    }

    // Helper methods for styling
    private static JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(INPUT_FONT);
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
                new EmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }

    private static JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private static void addFormRow(JPanel panel, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(LABEL_FONT);
        label.setForeground(TEXT_COLOR);
        panel.add(label);
        panel.add(textField);
    }

    private static void styleTextArea(JTextArea textArea) {
        textArea.setEditable(false);
        textArea.setFont(INPUT_FONT);
        textArea.setBackground(new Color(250, 251, 252));
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private static void updateShopStatsArea(CarShop shop, JTextArea shopStatsArea) {
        StringBuilder stats = new StringBuilder();
        stats.append("Total Inventory Value: ").append(shop.getTotalInventoryValue()).append(" Taka\n");
        stats.append("Average Car Price: ").append(String.format("%.2f", shop.getAveragePrice())).append(" Taka\n");
        
        Car mostExp = shop.getMostExpensiveCar();
        if (mostExp != null) {
            stats.append("Most Expensive Car: ").append(mostExp.getMake()).append(" ").append(mostExp.getModel())
                 .append(" (").append(mostExp.getPrice()).append(" Taka)\n");
        } else {
            stats.append("Most Expensive Car: N/A\n");
        }
        
        Car cheapest = shop.getCheapestCar();
        if (cheapest != null) {
            stats.append("Cheapest Car: ").append(cheapest.getMake()).append(" ").append(cheapest.getModel())
                 .append(" (").append(cheapest.getPrice()).append(" Taka)\n");
        } else {
            stats.append("Cheapest Car: N/A\n");
        }
        
        shopStatsArea.setText(stats.toString());
        shopStatsArea.setCaretPosition(0);
    }

    private static void updateCarListArea(CarShop shop, JTextArea carListArea) {
        StringBuilder carDetails = new StringBuilder();
        for (Car car : shop.getInventory()) {
            carDetails.append(car.displayCarInfo()).append("\n\n");
        }
        carListArea.setText(carDetails.toString());
        carListArea.setCaretPosition(0);
    }

    private static void updateAdminUserLog(JTextArea userTextArea) {
        StringBuilder allLogs = new StringBuilder();
        if (allCustomers.isEmpty()) {
            allLogs.append("No users have signed up yet.");
        } else {
            for (Customer c : allCustomers) {
                allLogs.append("--- CUSTOMER LOG ---\n");
                allLogs.append(c.getUserInfo()).append("\n");
            }
        }
        userTextArea.setText(allLogs.toString());
        userTextArea.setCaretPosition(0);
    }

    private static void clearInputs(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}