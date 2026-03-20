Project: Room Allocation & Confirmation ServiceOverview
This project implements Use Case 6: Reservation Confirmation & Room Allocation. It transitions from simple "intent" to "confirmation" by assigning unique, non-duplicable room IDs to guests based on their position in the booking queue.

Key Features

* Unique Room ID Generation: Automatically creates IDs like Single-1, Single-2, and Suite-1.
* Double-Booking Prevention: Uses a Set to track every assigned ID, ensuring no two guests ever get the same room.
* Immediate Inventory Update: Conceptually triggers an inventory decrement as soon as a room is successfully allocated.
* Sequential Processing: Integrates with a FIFO (First-In-First-Out) queue to ensure fair processing.

How to Run

1. Requirement: Java JDK installed.
2. Compile:

javac BookMyStayApp.java

3. Execute:

java BookMyStayApp

Expected Output
The program will display confirmed bookings with their unique IDs:

Room Allocation Processing

Booking confirmed for Guest: Abhi, Room ID: Single-1
Booking confirmed for Guest: Subha, Room ID: Single-2
Booking confirmed for Guest: Vanmathi, Room ID: Suite-1

Technical Details

* Version: 6.0
* Core Logic: RoomAllocationService
* Data Structure: HashSet (for uniqueness) and HashMap (for type counting).



