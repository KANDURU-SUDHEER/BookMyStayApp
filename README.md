Project: FIFO Booking Request QueueOverview
This project implements Use Case 5: Booking Request (FIFO). It focuses on the "First-Come, First-Served" principle for hotel reservations. By using a Queue data structure, the system ensures that guest requests are processed fairly in the exact order they were received.

Key Features

* Intent Capture: The Reservation class captures guest names and room types without immediately deducting inventory.
* Fair Allocation: Uses a Queue (LinkedList implementation) to manage requests.
* FIFO Logic: Implements addRequest (enqueue) and getNextRequest (dequeue) to maintain a strict processing order.

How to Run

1. Requirement: Ensure you have Java (JDK) installed.
2. Compile:

javac BookMyStayApp.java

3. Execute:

java BookMyStayApp


Expected Output
The program will simulate the sequential processing of guest requests:

Booking Request Queue
Processing booking for Guest: Abhi, Room Type: Single
Processing booking for Guest: Subha, Room Type: Double
Processing booking for Guest: Vanmathi, Room Type: Suite

Technical Details

* Version: 5.0
* Data Structure: java.util.Queue
* Pattern: First-In-First-Out (FIFO)



