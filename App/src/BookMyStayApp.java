/**
 * =========================================================================
 * HOTEL BOOKING MANAGEMENT SYSTEM - USE CASE 2 (COMPLETE)
 * =========================================================================
 *
 * Description:
 * This single runnable file contains the base Room model, specific
 * room implementations, and the main initialization logic.
 *
 * Version: 2.1
 * Author: KANDURU-SUDHEER
 */

/**
 * --- ABSTRACT BASE CLASS ---
 * Represents a generic hotel room with core attributes.
 * Inventory logic is excluded as per specifications.
 */
abstract class Room {
    protected int numberOfBeds;     // Number of beds in the room
    protected int squareFeet;       // Total size in sqft
    protected double pricePerNight; // Daily rate

    /**
     * Constructor for child classes to initialize attributes.
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /**
     * Prints the room details to the console in the required format.
     */
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

/**
 * --- CONCRETE CLASS: SingleRoom ---
 * Predefines values for a single room type.
 */
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/**
 * --- CONCRETE CLASS: DoubleRoom ---
 * Predefines values for a double room type.
 */
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/**
 * --- CONCRETE CLASS: SuiteRoom ---
 * Predefines values for a suite room type.
 */
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

/**
 * --- MAIN APPLICATION CLASS ---
 * Filename: UseCase2RoomInitialization.java
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        // Step 1: Initialize specific room objects using domain models
        SingleRoom single = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        // Step 2: Set static availability counts as per the provided image
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Step 3: Display output matching the requested formatting
        System.out.println("Hotel Room Initialization\n");

        // Single Room section
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailability + "\n");

        // Double Room section
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailability + "\n");

        // Suite Room section
        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailability);
    }
}
