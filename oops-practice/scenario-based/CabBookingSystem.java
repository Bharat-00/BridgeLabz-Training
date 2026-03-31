import java.util.ArrayList;
// Custom Exception
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}
// Interface for Fare Calculation
interface FareCalculator {
    double calculateFare(double distance);
}
// Normal Pricing
class NormalFare implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 10;
    }
}
// Peak Pricing
class PeakFare implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
// User Class
class User {
    String name;
    User(String name) {
        this.name = name;
    }
}
// Driver Class
class Driver {
    String name;
    boolean isAvailable = true;
    Driver(String name) {
        this.name = name;
    }
}
// Ride Class
class Ride {
    User user;
    Driver driver;
    double fare;
    Ride(User user, Driver driver, double fare) {
        this.user = user;
        this.driver = driver;
        this.fare = fare;
    }
}
// Main System
public class CabBookingSystem {
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Ride> rideHistory = new ArrayList<>();
    // Assign Driver
    public static Driver assignDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable) {
                d.isAvailable = false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No drivers available at the moment.");
    }
    // Book Ride
    public static void bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {
        Driver driver = assignDriver();
        double fare = fareCalculator.calculateFare(distance);
        Ride ride = new Ride(user, driver, fare);
        rideHistory.add(ride);
        System.out.println("Ride booked for " + user.name);
        System.out.println("Driver: " + driver.name);
        System.out.println("Fare: ₹" + fare);
    }
    // Display Ride History
    public static void displayRideHistory() {
        System.out.println("\n---- Ride History ----");
        for (Ride r : rideHistory) {
            System.out.println(r.user.name + " | Driver: " + r.driver.name + " | Fare: ₹" + r.fare);
        }
    }
    public static void main(String[] args) {
        drivers.add(new Driver("Ramesh"));
        drivers.add(new Driver("Suresh"));
        User user = new User("Amit");
        try {
            bookRide(user, 5, new NormalFare());
            bookRide(user, 3, new PeakFare());
        } catch (NoDriverAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        displayRideHistory();
    }
}
