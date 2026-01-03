public class VehicleRegistration {
    // Instance Variables
    private final String ownerName;
    private String vehicleType;
    // Class Variable (Fixed fee for all)
    private static double registrationFee = 500.0; 
    // Constructor
    public VehicleRegistration(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    // Instance Method
    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + " | Type: " + vehicleType + " | Reg Fee: $" + registrationFee);
    }
    // Class Method: Updates the shared fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println(">> Registration Fee changed to: $" + newFee);
    }
    // Main method to test
    public static void main(String[] args) {
        System.out.println("--- Problem 3: Vehicle Registration ---");
        VehicleRegistration v1 = new VehicleRegistration("Alice", "Sedan");
        VehicleRegistration v2 = new VehicleRegistration("Bob", "SUV");
        System.out.println("Current Fee Structure:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        System.out.println();
        // Change the fee globally
        VehicleRegistration.updateRegistrationFee(750.0);
        System.out.println("\nNew Fee Structure:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}