import java.util.*;
// Custom Exception
class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}
// Table Model
class Table {
    private int tableNumber;
    private boolean reserved;
    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.reserved = false;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void reserve() {
        this.reserved = true;
    }
    public void cancel() {
        this.reserved = false;
    }
}
// Reservation Model
class Reservation {
    private int tableNumber;
    private String customerName;
    public Reservation(int tableNumber, String customerName) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
}
// Service Class
class RestaurantService {
    private Map<Integer, Table> tableMap = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();
    public RestaurantService(int totalTables) {
        for (int i = 1; i <= totalTables; i++) {
            tableMap.put(i, new Table(i));
        }
    }
    public void reserveTable(int tableNumber, String customerName)
            throws TableAlreadyReservedException {
        Table table = tableMap.get(tableNumber);
        if (table.isReserved()) {
            throw new TableAlreadyReservedException(
                    "Table " + tableNumber + " is already reserved!");
        }
        table.reserve();
        reservations.add(new Reservation(tableNumber, customerName));
        System.out.println("Table " + tableNumber + " reserved for " + customerName);
    }
    public void cancelReservation(int tableNumber) {
        Table table = tableMap.get(tableNumber);
        table.cancel();
        reservations.removeIf(r -> r.getTableNumber() == tableNumber);
        System.out.println("Reservation cancelled for table " + tableNumber);
    }
    public void showAvailableTables() {
        System.out.println("Available Tables:");
        for (Table table : tableMap.values()) {
            if (!table.isReserved()) {
                System.out.println("Table " + table.getTableNumber());
            }
        }
    }
}
// Presentation Layer
public class RestaurantTableReservationSystem {
    public static void main(String[] args) {
        RestaurantService service = new RestaurantService(5);
        try {
            service.reserveTable(2, "Rahul");
            service.reserveTable(3, "Anita");
            service.reserveTable(2, "Amit"); // Exception case
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }
        service.showAvailableTables();
        service.cancelReservation(2);
        service.showAvailableTables();
    }
}
