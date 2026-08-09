# Car Shop Management System

## Overview
The **Car Shop Management System** is a Java-based desktop application designed to manage car inventories and customer interactions. It provides a Graphical User Interface (GUI) to handle various operations, such as adding vehicles to a shop's inventory, displaying vehicle properties (like taxes, depreciation, and insurance), and managing customer purchases and wallet balances.

## Academic Context
* **CSE110 (Object-Oriented Programming):** This project was originally developed as a core OOP project, demonstrating fundamental principles such as Inheritance, Abstraction, Encapsulation, and Polymorphism. 
* **CSE430 (Software Testing):** The project was later expanded to include comprehensive automated testing to ensure reliability, correctness, and robust exception handling as part of the Software Testing course.

## Technologies Used
* **Programming Language:** Java
* **User Interface:** Java Swing (GUI)
* **Testing Framework:** JUnit 5

## Project Architecture
The codebase is structured into logical sub-packages to maintain modularity and clear separation of concerns:

* **`carShop.vehicles`**: Contains the vehicle inheritance hierarchy.
  * `Car` (Abstract Base Class)
  * `Commuter` (Concrete Class for standard vehicles)
  * `Sports` (Concrete Class for high-performance vehicles)
* **`carShop.users`**: Manages the users interacting with the system.
  * `User` (Abstract Base Class)
  * `Customer` (Handles purchasing logic, wallet balances, VIP status calculation)
* **`carShop.inventory`**: Handles shop-level logic.
  * `CarShop` (Manages inventory arrays, searching, removing, and overall pricing calculations)
* **`carShop.Main`**: The entry point of the application containing the Swing GUI implementation.

## Testing Features (CSE430)
The testing suite utilizes JUnit 5 to cover different aspects of the application's logic. Some of the key software testing methodologies implemented include:
1. **Unit Testing:** Validates individual methods in models (e.g., checking if VIP status updates correctly in the `Customer` class).
2. **Integration Testing:** Tests workflows spanning multiple classes, such as a complete checkout flow between a `Customer` and a `CarShop`.
3. **Exception / Negative Testing:** Ensures the system correctly rejects invalid data, such as throwing an `IllegalArgumentException` for negative car prices.
4. **Parameterized Testing:** Uses `@ParameterizedTest` to run tests across multiple data sets (e.g., verifying case-insensitive search logic) without duplicating code.
5. **Boundary Value Testing:** Validates extreme edge cases, such as searching with `null` or empty strings, to prevent unexpected crashes.
