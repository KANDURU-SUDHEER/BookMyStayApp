import java.util.HashMap;
import java.util.Map;

/**
 * =====================================================================
 * CLASS - Room
 * =====================================================================
 *
 * Description:
 * Represents a specific type of hotel room.
 * This class holds the static characteristics of a room
 * which are referenced by the search and inventory systems.
 *
 * @version 4.0
 */
class Room {
    private String type;
    private double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getRoomType() { return type; }
    public double getRoomPrice() { return price; }
}

/**
 * =====================================================================
 * CLASS - RoomInventory
 * =====================================================================
 *
 * Description:
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * @version 4.0
 */
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void updateAvailability(String type, int count) {
        inventory.put(type, count);
    }

    public Map<String, Integer> getRoomAvailability() {
        return inventory;
    }
}

/**
 * =====================================================================
 * CLASS - RoomSearchService
 * =====================================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class provides search functionality for guests to view available rooms.
 * It reads room availability from inventory and room details from Room objects.
 *
 * No inventory mutation or booking logic is performed in this class.
 *
 * @version 4.0
 */
class RoomSearchService {

    /**
     * Displays available rooms along with their details and pricing.
     * This method performs read-only access to inventory and room data.
     *
     * @param inventory centralized room inventory
     * @param singleRoom single room definition
     * @param doubleRoom double room definition
     * @param suiteRoom suite room definition
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();
        System.out.println("=== Available Rooms ===");

        // Logic to display only rooms with availability > 0
        if (availability.getOrDefault("Single", 0) > 0) {
            displayRoom(singleRoom, availability.get("Single"));
        }
        if (availability.getOrDefault("Double", 0) > 0) {
            displayRoom(doubleRoom, availability.get("Double"));
        }
        if (availability.getOrDefault("Suite", 0) > 0) {
            displayRoom(suiteRoom, availability.get("Suite"));
        }
    }

    private void displayRoom(Room room, int count) {
        System.out.println("Type: " + room.getRoomType() + " | Price: $" + room.getRoomPrice() + " | Available: " + count);
    }
}

/**
 * =====================================================================
 * CLASS - BookMyStayApp
 * =====================================================================
 *
 * Description:
 * Main driver class for the BookMyStay application.
 * Orchestrates room setup, inventory initialization, and search services.
 *
 * @version 4.0
 */
public class BookMyStayApp {
    public static void main(String[] args) {
        // Setup Room Definitions (Static Details)
        Room single = new Room("Single Standard", 188.55);
        Room doubleR = new Room("Double Deluxe", 158.01);
        Room suite = new Room("Executive Suite", 300.01);

        // Setup Inventory (Dynamic Availability)
        RoomInventory inventory = new RoomInventory();
        inventory.updateAvailability("Single", 5);
        inventory.updateAvailability("Double", 2);
        inventory.updateAvailability("Suite", 0); // This room will not appear in search

        // Execute Search Service
        RoomSearchService service = new RoomSearchService();
        service.searchAvailableRooms(inventory, single, doubleR, suite);
    }
}
