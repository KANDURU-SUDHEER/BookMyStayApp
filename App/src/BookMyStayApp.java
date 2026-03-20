import java.util.HashMap;
import java.util.Map;

/**
 * CLASS - Room
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * Represents a specific type of hotel room.
 * This class holds the static characteristics of a room
 * which are referenced by the inventory system.
 *
 * @author [Your Name/Student ID]
 * @version 3.1
 */
class Room {
    private String type;
    private int beds;
    private int sizeSqft;
    private double pricePerNight;

    public Room(String type, int beds, int sizeSqft, double pricePerNight) {
        this.type = type;
        this.beds = beds;
        this.sizeSqft = sizeSqft;
        this.pricePerNight = pricePerNight;
    }

    // Getters to provide data to the Inventory Status
    public String getType() { return type; }
    public int getBeds() { return beds; }
    public int getSizeSqft() { return sizeSqft; }
    public double getPricePerNight() { return pricePerNight; }
}

/**
 * CLASS - RoomInventory
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * Room pricing and characteristics are obtained
 * from Room objects, not duplicated here.
 *
 * @author [Your Name/Student ID]
 * @version 3.1
 */
class RoomInventory {
    // Encapsulated map to ensure data integrity
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        this.roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Sets initial availability counts for the hotel.
     */
    private void initializeInventory() {
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

/**
 * CLASS - UseCase3InventorySetup
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * Driver class to demonstrate the setup of the room inventory.
 * Coordinates between Room objects and the Inventory manager.
 *
 * @author [Your Name/Student ID]
 * @version 3.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {
        // Instantiate Room objects with specific characteristics
        Room single = new Room("Single Room", 1, 250, 1500.0);
        Room doubleRm = new Room("Double Room", 2, 400, 2500.0);
        Room suite = new Room("Suite Room", 3, 750, 5000.0);

        // Initialize the centralized inventory manager
        RoomInventory inventory = new RoomInventory();
        Map<String, Integer> currentCounts = inventory.getRoomAvailability();

        // Print the final Inventory Status report
        System.out.println("Hotel Room Inventory Status\n");

        displayRoomStatus(single, currentCounts.get(single.getType()));
        displayRoomStatus(doubleRm, currentCounts.get(doubleRm.getType()));
        displayRoomStatus(suite, currentCounts.get(suite.getType()));
    }

    /**
     * Formats the output for each room type based on the provided requirements.
     */
    private static void displayRoomStatus(Room room, int count) {
        System.out.println(room.getType() + ":");
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSizeSqft() + " sqft");
        System.out.println("Price per night: " + room.getPricePerNight());
        System.out.println("Available Rooms: " + count);
        System.out.println();
    }
}
