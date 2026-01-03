// Program to demonstrate Vehicle Registration System
// Concepts used: static, this, final, instanceof
// Vehicle class definition
class Vehicle {
    // Static variable shared by all vehicles
    static double registrationFee = 150.0;
    // Instance variables
    private final String registrationNumber; // final variable (unique & immutable)
    private final String ownerName;
    private final String vehicleType;
    // Constructor using 'this' keyword
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);
        System.out.println();
    }
}
// Main class
public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Creating Vehicle objects
        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");
        // Checking instanceof before displaying details
        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayVehicleDetails();
        }
        if (vehicle2 instanceof Vehicle) {
            vehicle2.displayVehicleDetails();
        }
    }
}
