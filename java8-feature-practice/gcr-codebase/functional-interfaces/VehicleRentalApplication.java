public class VehicleRentalApplication {
    public static void main(String[] args) {
        // Creating vehicle objects using interface reference
        RentalVehicle car = new Car();
        RentalVehicle bike = new Bike();
        RentalVehicle bus = new Bus();
        // Performing rental operations
        car.rent();
        car.returnVehicle();
        bike.rent();
        bike.returnVehicle();
        bus.rent();
        bus.returnVehicle();
    }
}
// Common interface for all rental vehicles
interface RentalVehicle {
    // Rents the vehicle
    void rent();
    // Returns the rented vehicle
    void returnVehicle();
}
// Car rental implementation
class Car implements RentalVehicle {
    @Override
    public void rent() {
        System.out.println("Car has been rented");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Car has been returned");
    }
}
// Bike rental implementation
class Bike implements RentalVehicle {
    @Override
    public void rent() {
        System.out.println("Bike has been rented");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Bike has been returned");
    }
}
// Bus rental implementation
class Bus implements RentalVehicle {
    @Override
    public void rent() {
        System.out.println("Bus has been rented");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Bus has been returned");
    }
}
