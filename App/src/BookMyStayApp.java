import java.util.*;

/**
 * =========================================================================
 * CLASS - Reservation
 * =========================================================================
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

/**
 * =========================================================================
 * CLASS - RoomInventory
 * =========================================================================
 */
class RoomInventory {
    // Conceptually updates available counts
    public void updateInventory(String roomType, int change) {
        // In a full system, this would decrement the database count
    }
}

/**
 * =========================================================================
 * CLASS - RoomAllocationService
 * =========================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
class RoomAllocationService {
    // Tracks overall unique IDs to prevent double-booking
    private Set<String> allocatedRoomIds;
    // Tracks IDs per type to handle sequential numbering (e.g., Single-1, Single-2)
    private Map<String, Integer> roomTypeCounters;

    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.roomTypeCounters = new HashMap<>();
    }

    /**
     * Confirms a booking, generates a unique ID, and updates inventory.
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        String roomId = generateRoomId(type);

        // Mark as allocated
        allocatedRoomIds.add(roomId);

        // Update inventory immediately (decrements by 1)
        inventory.updateInventory(type, -1);

        // Specific output format for confirmation
        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                ", Room ID: " + roomId);
    }

    /**
     * Generates a unique room ID based on the room type.
     */
    private String generateRoomId(String roomType) {
        int nextNumber = roomTypeCounters.getOrDefault(roomType, 0) + 1;
        String newId = roomType + "-" + nextNumber;

        // Ensure absolute uniqueness
        while (allocatedRoomIds.contains(newId)) {
            nextNumber++;
            newId = roomType + "-" + nextNumber;
        }

        roomTypeCounters.put(roomType, nextNumber);
        return newId;
    }
}

/**
 * =========================================================================
 * MAIN CLASS - BookMyStayApp
 * =========================================================================
 */
public class BookMyStayApp {

    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");

        // 1. Initialize Service and Inventory
        RoomAllocationService service = new RoomAllocationService();
        RoomInventory inventory = new RoomInventory();

        // 2. Setup FIFO Queue for booking requests
        Queue<Reservation> bookingRequests = new LinkedList<>();

        // 3. Add requests in order
        bookingRequests.add(new Reservation("Abhi", "Single"));
        bookingRequests.add(new Reservation("Subha", "Single"));
        bookingRequests.add(new Reservation("Vanmathi", "Suite"));

        // 4. Process the queue (First-In, First-Out)
        while (!bookingRequests.isEmpty()) {
            Reservation request = bookingRequests.poll();
            service.allocateRoom(request, inventory);
        }
    }
}
