//Superclass
class Device {
    String deviceId;
    String status;
    Device(String deviceId,String status){
        this.deviceId=deviceId;
        this.status=status;
    }
}
//Subclass
class Thermostat extends Device {
    int temperatureSetting;
    Thermostat(String deviceId,String status,int temperatureSetting){
        super(deviceId,status);
        this.temperatureSetting=temperatureSetting;
    }
    //Method to display device status
    void displayStatus(){
        System.out.println("DeviceId:"+deviceId);
        System.out.println("Status:"+status);
        System.out.println("TemperatureSetting:"+temperatureSetting);
    }
}
public class SmartHomeDevices {
    public static void main(String[] args){
        Thermostat thermostat=new Thermostat(
                "TH1001",
                "ON",
                24
        );
        thermostat.displayStatus();
    }
}
