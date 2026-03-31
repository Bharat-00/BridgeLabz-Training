import java.util.ArrayList;
import java.util.List;
// Flight class
class Flight {
    String flightNumber;
    String source;
    String destination;
    public Flight(String flightNumber, String source, String destination) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
    }
}
// Booking class
class Booking {
    private final String passengerName;
    private final Flight flight;
    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }
    public void displayBooking() {
        System.out.println(passengerName + " booked " +
                flight.flightNumber + " (" +
                flight.source + " → " +
                flight.destination + ")");
    }
}
// Main system class
public class FlightBookingSystem {
    static Flight[] availableFlights = {
            new Flight("AI101", "Delhi", "Mumbai"),
            new Flight("AI202", "Delhi", "Chennai"),
            new Flight("AI303", "Mumbai", "Bangalore")
    };
    static List<Booking> bookings = new ArrayList<>();
    // Search flight (case-insensitive)
    public static Flight searchFlight(String source, String destination) {
        for (Flight flight : availableFlights) {
            if (flight.source.equalsIgnoreCase(source) &&
                flight.destination.equalsIgnoreCase(destination)) {
                return flight;
            }
        }
        return null;
    }
    // Book flight
    public static void bookFlight(String passengerName, Flight flight) {
        bookings.add(new Booking(passengerName, flight));
        System.out.println("Flight booked successfully!");
    }
    // Display bookings
    public static void displayBookings() {
        System.out.println("\nBooking Details:");
        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }
    public static void main(String[] args) {
        Flight flight = searchFlight("Delhi", "Mumbai");

        if (flight != null) {
            bookFlight("Rohit", flight);
        } else {
            System.out.println("Flight not found");
        }

        displayBookings();
    }
}
