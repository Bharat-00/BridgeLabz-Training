public class SmartHomeApplication {
    public static void main(String[] args) {
        // Creating device objects using interface reference
        SmartDevice light = new Light();
        SmartDevice airConditioner = new AirConditioner();
        SmartDevice television = new Television();
        // Operating devices
        light.turnOn();
        light.turnOff();
        airConditioner.turnOn();
        airConditioner.turnOff();
        television.turnOn();
        television.turnOff();
    }
}
// Common interface for all smart devices
interface SmartDevice {
    // Turns the device ON
    void turnOn();
    // Turns the device OFF
    void turnOff();
}
// Implementation for Light device
class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("Light turned OFF");
    }
}
// Implementation for Air Conditioner device
class AirConditioner implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Air Conditioner turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("Air Conditioner turned OFF");
    }
}
// Implementation for Television device
class Television implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Television turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("Television turned OFF");
    }
}
