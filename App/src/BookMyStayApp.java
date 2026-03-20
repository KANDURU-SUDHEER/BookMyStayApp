import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * =====================================================================
 * CLASS - Service
 * =====================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class represents an optional service
 * that can be added to a confirmed reservation.
 *
 * Examples:
 * - Breakfast
 * - Spa
 * - Airport Pickup
 *
 * @version 7.0
 */
class AddOnService {
    /** Name of the service. */
    private String serviceName;

    /** Cost of the service. */
    private double cost;

    /**
     * Creates a new add-on service.
     *
     * @param serviceName name of the service
     * @param cost cost of the service
     */
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    /** @return service name */
    public String getServiceName() {
        return serviceName;
    }

    /** @return service cost */
    public double getCost() {
        return cost;
    }
}

/**
 * =====================================================================
 * CLASS - AddOnServiceManager
 * =====================================================================
 *
 * Description:
 * This class manages optional services associated with confirmed reservations.
 * It uses a Map to link Reservation IDs to a List of selected services.
 *
 * @version 7.0
 */
class AddOnServiceManager {
    /**
     * Maps reservation ID to selected services.
     * Key -> Reservation ID (e.g., "Single-1")
     * Value -> List of selected AddOnService objects
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /** Initializes the service manager. */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Attaches a service to a reservation.
     *
     * @param reservationId confirmed reservation ID
     * @param service add-on service to be added
     */
    public void addService(String reservationId, AddOnService service) {
        servicesByReservation.computeIfAbsent(reservationId, k -> new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    /**
     * Calculates total add-on cost for a specific reservation.
     *
     * @param reservationId reservation ID to calculate for
     * @return total service cost for that ID
     */
    public double calculateTotalServiceCost(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);
        if (services == null) return 0.0;

        double total = 0.0;
        for (AddOnService s : services) {
            total += s.getCost();
        }
        return total;
    }
}

/**
 * =====================================================================
 * MAIN CLASS - BookMyStayApp
 * =====================================================================
 *
 * Description:
 * Driver class demonstrating the Add-On Service Selection process.
 * Links services like Spa and Breakfast to an existing Reservation ID.
 *
 * @version 7.0
 */
public class BookMyStayApp {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Initialize manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Target Reservation ID (Assumed from Use Case 6 output)
        String resId = "Single-1";

        // Create and add services based on requirements
        manager.addService(resId, new AddOnService("Spa", 1000.0));
        manager.addService(resId, new AddOnService("Breakfast", 500.0));

        // Calculate the total additional cost
        double totalCost = manager.calculateTotalServiceCost(resId);

        // Print final status output
        System.out.println("Add-On Service Selection");
        System.out.println("-------------------------");
        System.out.println("Reservation ID: " + resId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
