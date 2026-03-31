import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class Vehicle {
    // Encapsulated fields
    private final int vehicleId;
    private final String driverName;
    protected double ratePerKm;
    // Constructor
    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    // Abstract method
    public abstract double calculateFare(double distance);
    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID  : " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate/Km    : ₹" + ratePerKm);
    }
}
/* -------------------- CAR -------------------- */
class Car extends Vehicle implements GPS {
    private String location = "Unknown";
    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
    @Override
    public String getCurrentLocation() {
        return location;
    }
    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}
/* -------------------- BIKE -------------------- */
class Bike extends Vehicle implements GPS {
    private String location = "Unknown";
    public Bike(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm * 0.8;
    }
    @Override
    public String getCurrentLocation() {
        return location;
    }
    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}
/* -------------------- AUTO -------------------- */
class Auto extends Vehicle implements GPS {
    private String location = "Unknown";
    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm * 0.9;
    }
    @Override
    public String getCurrentLocation() {
        return location;
    }
    @Override
    public void updateLocation(String location) {
        this.location = location;
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class RideHailingApplication {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(101, "Suresh", 15));
        vehicles.add(new Bike(102, "Aman", 10));
        vehicles.add(new Auto(103, "Ramesh", 12));
        double distance = 10;
        System.out.println("===== Ride Fare Details =====");
        // Polymorphism
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Distance    : " + distance + " km");
            System.out.println("Fare        : ₹" + vehicle.calculateFare(distance));
            if (vehicle instanceof GPS gps) {
                gps.updateLocation("City Center");
                System.out.println("Location    : " + gps.getCurrentLocation());
            }
            System.out.println("--------------------------------");
        }
    }
}
