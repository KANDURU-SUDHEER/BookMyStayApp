Project: Centralized Hotel Room Inventory
Overview
This project implements Use Case 3: Centralized Room Inventory Management. It is designed using the "Single Source of Truth" pattern, ensuring that room details (like price and size) and room availability are managed in one place without data duplication.
Key Features
Centralized Tracking: Uses a RoomInventory class to manage all availability counts.
Separation of Concerns: Room objects handle static data, while the Inventory handles dynamic state.
Efficient Data Storage: Uses a Java HashMap for quick room type lookups and updates.
How to Run
Requirement: Ensure you have Java (JDK) installed.
Compile:
bash
javac UseCase3InventorySetup.java
Use code with caution.

Execute:
bash
java UseCase3InventorySetup
Use code with caution.

Expected Output
The program will display the current status of the hotel inventory:
Single Room: 5 available
Double Room: 3 available
Suite Room: 2 available
Author Information
Module: Use Case 3
Version: 3.1
Author: KANDURU-SUDHEER
