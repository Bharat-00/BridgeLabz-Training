//Interface for refueling capability
interface Refuelable {
    void refuel();
}
//Superclass
class Vehicle {
    int maxSpeed;
    String model;
    Vehicle(int maxSpeed,String model){
        this.maxSpeed=maxSpeed;
        this.model=model;
    }
}
//ElectricVehicle subclass
class ElectricVehicle extends Vehicle {
    ElectricVehicle(int maxSpeed,String model){
        super(maxSpeed,model);
    }
    void charge(){
        System.out.println("ElectricVehicleCharging");
    }
}
//PetrolVehicle subclass implementing interface
class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(int maxSpeed,String model){
        super(maxSpeed,model);
    }
    @Override
    public void refuel(){
        System.out.println("PetrolVehicleRefueling");
    }
}
public class VehicleManagementSystem {
    public static void main(String[] args){
        ElectricVehicle ev=new ElectricVehicle(150,"Tesla");
        PetrolVehicle pv=new PetrolVehicle(180,"HondaCity");
        ev.charge();
        pv.refuel();
    }
}
