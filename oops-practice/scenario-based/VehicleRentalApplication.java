// Rentable interface
interface IRentable {
    double calculateRent(int days);
}
// Abstract Vehicle class
abstract class Vehicle implements IRentable {
    protected String vehicleNumber;
    protected double ratePerDay;
    public Vehicle(String vehicleNumber, double ratePerDay) {
        this.vehicleNumber = vehicleNumber;
        this.ratePerDay = ratePerDay;
    }
}
// Bike class
class Bike extends Vehicle {
    public Bike(String number) {
        super(number, 500);
    }
    @Override
    public double calculateRent(int days) {
        return days * ratePerDay;
    }
}
// Car class
class Car extends Vehicle {
    public Car(String number) {
        super(number, 1200);
    }
    @Override
    public double calculateRent(int days) {
        return days * ratePerDay;
    }
}
// Truck class
class Truck extends Vehicle {
    public Truck(String number) {
        super(number, 2500);
    }
    @Override
    public double calculateRent(int days) {
        return days * ratePerDay;
    }
}
// Customer class
class Customer {
    private final String customerName;
    public Customer(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return customerName;
    }
}
// Main class
public class VehicleRentalApplication {
    public static void main(String[] args) {
        Customer customer = new Customer("Amit");
        Vehicle bike = new Bike("BIKE-11");
        Vehicle car = new Car("CAR-22");
        Vehicle truck = new Truck("TRUCK-33");
        System.out.println(customer.getCustomerName() + " Bike Rent: ₹" + bike.calculateRent(3));
        System.out.println(customer.getCustomerName() + " Car Rent: ₹" + car.calculateRent(2));
        System.out.println(customer.getCustomerName() + " Truck Rent: ₹" + truck.calculateRent(1));
    }
}
