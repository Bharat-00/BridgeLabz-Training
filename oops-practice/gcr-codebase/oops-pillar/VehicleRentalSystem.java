import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class Vehicle {
    // Encapsulated fields
    private final String vehicleNumber;
    private final String type;
    protected double rentalRate;
    private final String insurancePolicyNumber;
    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    // Abstract method
    public abstract double calculateRentalCost(int days);
    // Getter methods
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public String getType() {
        return type;
    }
    // Encapsulation: no direct access to policy number
    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }
}
/* -------------------- CAR -------------------- */
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }
    @Override
    public double calculateInsurance() {
        return 500;
    }
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy Active";
    }
}
/* -------------------- BIKE -------------------- */
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }
    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }
    @Override
    public double calculateInsurance() {
        return 200;
    }
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy Active";
    }
}
/* -------------------- TRUCK -------------------- */
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }
    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 1000; // Extra load charge
    }
    @Override
    public double calculateInsurance() {
        return 1000;
    }
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy Active";
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("MH12AB1234", 2000, "CAR123"));
        vehicles.add(new Bike("MH14CD5678", 500, "BIKE456"));
        vehicles.add(new Truck("MH20EF9012", 5000, "TRUCK789"));
        int rentalDays = 3;
        System.out.println("===== Vehicle Rental Details =====");
        // Polymorphism
        for (Vehicle vehicle : vehicles) {
            if (vehicle == null) {
                continue;
            }
            double insurance = 0;
            if (vehicle instanceof Insurable insurable) {
                insurance = insurable.calculateInsurance();
            }
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Vehicle Type   : " + vehicle.getType());
            System.out.println("Vehicle Number : " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost   : ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insurance);
            System.out.println("---------------------------------");
        }
    }
}
