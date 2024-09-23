package carShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        CarShop shop = new CarShop();
        Customer currentCustomer = new Customer();

        // Create the main frame
        JFrame frame = new JFrame("Car Shop Management System");
        frame.setSize(1200, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel using CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());

        // Admin Panel Components
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        adminPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // add admin panel title
        JLabel adminTitle = new JLabel("Admin Panel");
        adminTitle.setFont(new Font("Arial", Font.BOLD, 24));
        adminTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminPanel.add(adminTitle);

        // Tabs for different car types
        JTabbedPane tabbedPane = new JTabbedPane();

        // Commuter Car Panel
        JPanel commuterCarPanel = new JPanel();
        commuterCarPanel.setLayout(new BoxLayout(commuterCarPanel, BoxLayout.Y_AXIS));

        // Commuter Car Specific Inputs
        JTextField commuterMakeInput = new JTextField(20);
        JTextField commuterModelInput = new JTextField(20);
        JTextField commuterYearInput = new JTextField(20);
        JTextField commuterPriceInput = new JTextField(20);
        JTextField fuelEfficiencyInput = new JTextField(20);
        JTextField seatingCapacityInput = new JTextField(20);
        JTextField trunkSpaceInput = new JTextField(20);

        // Add fields to commuterCarPanel
        commuterCarPanel.add(new JLabel("Car Make:"));
        commuterCarPanel.add(commuterMakeInput);
        commuterCarPanel.add(new JLabel("Car Model:"));
        commuterCarPanel.add(commuterModelInput);
        commuterCarPanel.add(new JLabel("Car Year: int"));
        commuterCarPanel.add(commuterYearInput);
        commuterCarPanel.add(new JLabel("Car Price: int"));
        commuterCarPanel.add(commuterPriceInput);

        commuterCarPanel.add(new JLabel("Fuel Efficiency (kmpl): double"));
        commuterCarPanel.add(fuelEfficiencyInput);
        commuterCarPanel.add(new JLabel("Seating Capacity: int"));
        commuterCarPanel.add(seatingCapacityInput);
        commuterCarPanel.add(new JLabel("Trunk Space (liters): double"));
        commuterCarPanel.add(trunkSpaceInput);

        JButton addCommuterCarButton = new JButton("Add Commuter Car");
        commuterCarPanel.add(addCommuterCarButton);

        // Sports Car Panel
        JPanel sportsCarPanel = new JPanel();
        sportsCarPanel.setLayout(new BoxLayout(sportsCarPanel, BoxLayout.Y_AXIS));

        // Sports Car Specific Inputs
        JTextField sportsMakeInput = new JTextField(20);
        JTextField sportsModelInput = new JTextField(20);
        JTextField sportsYearInput = new JTextField(20);
        JTextField sportsPriceInput = new JTextField(20);
        JTextField horsepowerInput = new JTextField(20);
        JTextField topSpeedInput = new JTextField(20);
        JTextField accelerationInput = new JTextField(20);

        // Add fields to sportsCarPanel
        sportsCarPanel.add(new JLabel("Car Make:"));
        sportsCarPanel.add(sportsMakeInput);
        sportsCarPanel.add(new JLabel("Car Model:"));
        sportsCarPanel.add(sportsModelInput);
        sportsCarPanel.add(new JLabel("Car Year: int"));
        sportsCarPanel.add(sportsYearInput);
        sportsCarPanel.add(new JLabel("Car Price: int"));
        sportsCarPanel.add(sportsPriceInput);

        sportsCarPanel.add(new JLabel("Horsepower (hp): int"));
        sportsCarPanel.add(horsepowerInput);
        sportsCarPanel.add(new JLabel("Top Speed (kmph): int"));
        sportsCarPanel.add(topSpeedInput);
        sportsCarPanel.add(new JLabel("Acceleration in seconds (0-60 kmph): double"));
        sportsCarPanel.add(accelerationInput);

        JButton addSportsCarButton = new JButton("Add Sports Car");
        sportsCarPanel.add(addSportsCarButton);

        // Add both car panels to the tabbed pane
        tabbedPane.addTab("Add Commuter Car", commuterCarPanel);
        tabbedPane.addTab("Add Sports Car", sportsCarPanel);

        // Add the tabbed pane to the admin panel
        adminPanel.add(tabbedPane);

        // Text area to list added cars
        JTextArea carListArea = new JTextArea(8, 30);
        carListArea.setEditable(false);
        carListArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(carListArea);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        JLabel carListLabel = new JLabel("Car List:");
        carListLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align the label
        adminPanel.add(carListLabel);
        adminPanel.add(scrollPane);

        // Text area to list user information
        JTextArea userTextArea = new JTextArea(10, 30);
        userTextArea.setEditable(false);
        userTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPaneUser = new JScrollPane(userTextArea);
        scrollPaneUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        JLabel userInfoLabel = new JLabel("User Info:");
        userInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center align the label
        adminPanel.add(userInfoLabel);
        adminPanel.add(scrollPaneUser);

        // User Signup Panel
        JPanel userSignupPanel = new JPanel();
        userSignupPanel.setLayout(new BoxLayout(userSignupPanel, BoxLayout.Y_AXIS));
        userSignupPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // user signup big title
        JLabel userSignupTitle = new JLabel("User Signup");
        userSignupTitle.setFont(new Font("Arial", Font.BOLD, 24));
        userSignupTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField userNameInput = new JTextField(20);
        JTextField userAddressInput = new JTextField(20);
        JTextField userContactInput = new JTextField(20);
        JButton signupButton = new JButton("Sign Up");

        userNameInput.setMaximumSize(new Dimension(400, 30));
        userAddressInput.setMaximumSize(new Dimension(400, 30));
        userContactInput.setMaximumSize(new Dimension(400, 30));

        userSignupPanel.add(userSignupTitle);
        userSignupPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

        // signup form input
        JLabel userNameLabel = new JLabel("Name:");
        userNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userNameLabel);
        userNameInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userNameInput);

        userSignupPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        // signup form input
        JLabel userAddressLabel = new JLabel("Address:");
        userAddressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userAddressLabel);
        userAddressInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userAddressInput);

        userSignupPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        // signup form input
        JLabel userContactLabel = new JLabel("Contact Info:");
        userContactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userContactLabel);
        userContactInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(userContactInput);

        // signup form submit button
        userSignupPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        userSignupPanel.add(signupButton);

        // User Car Listing Panel
        JPanel userCarListPanel = new JPanel();
        userCarListPanel.setLayout(new BoxLayout(userCarListPanel, BoxLayout.Y_AXIS));
        userCarListPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Add panels to the main panel
        mainPanel.add(adminPanel, "adminPanel");
        mainPanel.add(userSignupPanel, "userSignupPanel");
        mainPanel.add(userCarListPanel, "userCarListPanel");

        // Layout for the button to switch between admin and user panels
        JPanel controlPanel = new JPanel();
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        JButton toggleButton = new JButton("Switch to Admin Panel");
        controlPanel.add(toggleButton);

        // Set up the layout of the main frame
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Initially show the user signup panel
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "userSignupPanel");

        // Toggle button to switch between user and admin panels
        toggleButton.addActionListener(new ActionListener() {
            boolean isAdmin = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAdmin) {
                    cl.show(mainPanel, "userSignupPanel");
                    toggleButton.setText("Switch to Admin Panel");
                } else {
                    cl.show(mainPanel, "adminPanel");
                    toggleButton.setText("Switch to User Panel");
                }
                isAdmin = !isAdmin;
            }
        });

        // Action listener for adding commuter cars
        addCommuterCarButton.addActionListener(e -> {
            try {
                String carMake = commuterMakeInput.getText();
                String carModel = commuterModelInput.getText();
                String carYear = commuterYearInput.getText();
                String carPrice = commuterPriceInput.getText();
                String fuelEfficiency = fuelEfficiencyInput.getText();
                String seatingCapacity = seatingCapacityInput.getText();
                String trunkSpace = trunkSpaceInput.getText();

                // Ensure fields are not empty
                if (carMake.isEmpty() || carModel.isEmpty() || carYear.isEmpty() || carPrice.isEmpty() ||
                        fuelEfficiency.isEmpty() || seatingCapacity.isEmpty() || trunkSpace.isEmpty()) {
                    throw new IllegalArgumentException("Please fill out all fields!");
                }

                // Convert numeric fields to the appropriate types and handle NumberFormatException
                int year = Integer.parseInt(carYear);
                int price = Integer.parseInt(carPrice);
                double efficiency = Double.parseDouble(fuelEfficiency);
                int capacity = Integer.parseInt(seatingCapacity);
                double trunk = Double.parseDouble(trunkSpace);

                shop.addCarToInventory(new Commuter(carMake, carModel, year, price, efficiency, capacity, trunk));

                // Display all the cars in the carListArea
                String carDetails = "";
                for (Car car : shop.getInventory()) {
                    carDetails += car.displayCarInfo() + "\n\n";
                }
                carListArea.setText(carDetails);

                JOptionPane.showMessageDialog(frame, "Commuter car added successfully!");
            } catch (NumberFormatException nfe) {
                // Handle invalid number formats
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for year, price, fuel efficiency, seating capacity, and trunk space!");
            }
        });

        // Action listener for adding sports cars
        addSportsCarButton.addActionListener(e -> {
            try {
                String carMake = sportsMakeInput.getText();
                String carModel = sportsModelInput.getText();
                String carYear = sportsYearInput.getText();
                String carPrice = sportsPriceInput.getText();
                String horsepower = horsepowerInput.getText();
                String topSpeed = topSpeedInput.getText();
                String acceleration = accelerationInput.getText();

                // Ensure fields are not empty
                if (carMake.isEmpty() || carModel.isEmpty() || carYear.isEmpty() || carPrice.isEmpty() ||
                        horsepower.isEmpty() || topSpeed.isEmpty() || acceleration.isEmpty()) {
                    throw new IllegalArgumentException("Please fill out all fields!");
                }

                // Convert numeric fields to the appropriate types and handle NumberFormatException
                int year = Integer.parseInt(carYear);
                int price = Integer.parseInt(carPrice);
                int hp = Integer.parseInt(horsepower);
                int speed = Integer.parseInt(topSpeed);
                double accel = Double.parseDouble(acceleration);

                shop.addCarToInventory(new Sports(carMake, carModel, year, price, hp, speed, accel));

                String carDetails = "";
                for (Car car : shop.getInventory()) {
                    carDetails += car.displayCarInfo() + "\n\n";
                }
                carListArea.setText(carDetails);

                // Show success message
                JOptionPane.showMessageDialog(frame, "Sports car added successfully!");
            } catch (NumberFormatException nfe) {
                // Handle invalid number formats
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for year, price, horsepower, top speed, and acceleration!",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for user sign up
        signupButton.addActionListener(e -> {
            String userName = userNameInput.getText();
            String userAddress = userAddressInput.getText();
            String userContact = userContactInput.getText();

            if (!userName.isEmpty() && !userAddress.isEmpty() && !userContact.isEmpty()) {

                if (currentCustomer.getName() != null && !currentCustomer.getName().equalsIgnoreCase(userName)) {
                    currentCustomer.setPurchasedCarsEmpty();
                }

                currentCustomer.setName(userName);
                currentCustomer.setAddress(userAddress);
                currentCustomer.setContactInfo(userContact);

                userTextArea.setText(currentCustomer.getUserInfo());

                // Simulate sign-up success and switch to car listing panel
                cl.show(mainPanel, "userCarListPanel");
                userCarListPanel.removeAll();  // Clear previous components

                // add car shop title
                JLabel shopTitle = new JLabel("Car Shop");
                shopTitle.setFont(new Font("Arial", Font.BOLD, 24));
                shopTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
                userCarListPanel.add(shopTitle);
                userCarListPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

                // if inventory's not empty, show the list of cars with a "Buy" button next to each
                if (shop.getInventory().isEmpty()) {
                    // add car shop title
                    JLabel noCarsLabel = new JLabel("No cars found to browse from.");
                    noCarsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
                    noCarsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    userCarListPanel.add(noCarsLabel);
                } else {
                    for (Car car : shop.getInventory()) {
                        JPanel carPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        JLabel carLabel = new JLabel(car.displayCarInfo());
                        JButton buyButton = new JButton("Buy");

                        // Add ActionListener for the Buy button
                        buyButton.addActionListener(e1 -> {
                            currentCustomer.updatePurchasedCars(car);
                            userTextArea.setText(currentCustomer.getUserInfo());
                            JOptionPane.showMessageDialog(frame, "Contgatulations! You bought a " + car.getMake() + " " + car.getModel() + ".");
                        });

                        carPanel.add(carLabel);
                        carPanel.add(buyButton);
                        userCarListPanel.add(carPanel);
                    }
                }

                userCarListPanel.revalidate();
                userCarListPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields!");
            }
        });

        frame.setVisible(true);
    }
}