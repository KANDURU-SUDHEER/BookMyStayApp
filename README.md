Project: Add-On Service SelectionOverview
This project implements Use Case 7: Add-On Service Selection. It allows guests with confirmed reservations to customize their stay by adding optional services like Spa treatments, Breakfast, or Airport Pickups. The system automatically tracks these selections and calculates the additional costs per reservation.

Key Features

* Service Personalization: Enables adding multiple extra services to a specific Reservation ID.
* Dynamic Cost Calculation: Automatically sums up the costs of all selected services for a guest.
* Flexible Data Mapping: Uses a HashMap to link a single reservation ID to a List of multiple selected services.
* Pre-defined Examples: Includes standard hospitality services like Spa ($1000.0) and Breakfast ($500.0).

How to Run

1. Requirement: Java JDK installed.
2. Compile:

javac BookMyStayApp.java

3. Execute:

java BookMyStayApp

Expected Output
The program will display the accumulated costs for a specific reservation:

Add-On Service Selection

Reservation ID: Single-1
Total Add-On Cost: 1500.0


Technical Details

* Version: 7.0
* Core Logic: AddOnServiceManager
* Data Structures: HashMap<String, List<AddOnService>>


