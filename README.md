This README provides a comprehensive guide for Use Case 11, focusing on the transition from a single-user system to a multi-threaded environment.
------------------------------
## Use Case 11: Concurrent Booking Simulation
Goal: Demonstrate how the system maintains integrity and prevents "double-booking" when multiple guests attempt to book rooms at the exact same time.
## Overview
In a real-world scenario, a booking system isn't used by one person at a time. Hundreds of requests may arrive simultaneously. Without proper Thread Safety, the system could suffer from Race Conditions, where two users are assigned the same room because the system hasn't finished updating the inventory for the first user before processing the second.
## Key Concepts Implemented

* Thread Safety: Ensuring shared resources (Inventory and Queue) behave correctly when accessed by multiple threads.
* Critical Sections: Using the synchronized keyword to protect blocks of code that modify shared data.
* Shared Mutable State: Managing the RoomInventory and BookingRequestQueue across different worker threads (t1 and t2).
* Atomicity: Ensuring the "Check Availability -> Decrement Inventory" process happens as a single, uninterrupted operation.

------------------------------
## System Architecture

| Component | Responsibility |
|---|---|
| RoomInventory | The Shared Resource. Contains a synchronized method to safely decrement room counts. |
| BookingRequestQueue | A synchronized list of guest names waiting for a room. |
| AllocationService | Contains the core logic for matching a guest to a room. |
| ConcurrentBookingProcessor | Implements Runnable. This is the "Worker" that runs on a background thread to process the queue. |
| UseCase11ThreadSafety | The Driver Class. It initializes threads, starts them, and uses .join() to synchronize the final report. |

------------------------------
## How to Run

1. File Name: Ensure your file is named UseCase11ThreadSafety.java.
2. Compile:

javac UseCase11ThreadSafety.java

3. Execute:

java UseCase11ThreadSafety

   
------------------------------
## Expected Behavior
When you run this simulation with 2 rooms and 5 guests:

1. Thread-01 and Thread-02 will start simultaneously.
2. They will "compete" to pull guests from the queue.
3. Only the first two guests to reach the allocateRoom logic will succeed.
4. The remaining three guests will be safely denied because the inventory count is protected.
5. The final inventory count will be 0 (never negative).

------------------------------
## Benefits of this Design

* Scalability: The system can now handle multiple processors working in parallel.
* Reliability: Eliminates the risk of "Double Booking," which is critical for business reputation.
* Predictability: The system state remains consistent regardless of how many threads are added.

------------------------------

