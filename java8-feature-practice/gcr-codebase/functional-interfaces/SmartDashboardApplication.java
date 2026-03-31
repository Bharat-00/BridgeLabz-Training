// Vehicle interface with default displaySpeed
interface Vehicle {
    void displaySpeed();
    // Default battery display for electric vehicles
    default void displayBatteryPercentage() {
        System.out.println("Battery percentage not available");
    }
}
class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 80 km/h");
    }
    public void displayBatteryPercentage() {
        System.out.println("Battery: 75%");
    }
}
class PetrolCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Speed: 60 km/h");
    }
}
public class SmartDashboardApplication {
    public static void main(String[] args) {
        Vehicle electric = new ElectricCar();
        Vehicle petrol = new PetrolCar();
        electric.displaySpeed();
        electric.displayBatteryPercentage();
        petrol.displaySpeed();
        petrol.displayBatteryPercentage();
    }
}
