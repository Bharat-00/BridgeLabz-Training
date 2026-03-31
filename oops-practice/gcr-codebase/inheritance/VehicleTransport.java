//Superclass
class Vehicle {
    int maxSpeed;
    String fuelType;
    Vehicle(int maxSpeed,String fuelType){
        this.maxSpeed=maxSpeed;
        this.fuelType=fuelType;
    }
    void displayInfo(){
        System.out.println("MaxSpeed:"+maxSpeed);
        System.out.println("FuelType:"+fuelType);
    }
}
//Car subclass
class Car extends Vehicle{
    int seatCapacity;
    Car(int maxSpeed,String fuelType,int seatCapacity){
        super(maxSpeed,fuelType);
        this.seatCapacity=seatCapacity;
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("SeatCapacity:"+seatCapacity);
    }
}
//Truck subclass
class Truck extends Vehicle{
    int loadCapacity;

    Truck(int maxSpeed,String fuelType,int loadCapacity){
        super(maxSpeed,fuelType);
        this.loadCapacity=loadCapacity;
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("LoadCapacity:"+loadCapacity);
    }
}
//Motorcycle subclass
class Motorcycle extends Vehicle{
    boolean hasGear;
    Motorcycle(int maxSpeed,String fuelType,boolean hasGear){
        super(maxSpeed,fuelType);
        this.hasGear=hasGear;
    }
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("HasGear:"+hasGear);
    }
}
public class VehicleTransport {
    public static void main(String[] args){
        Vehicle[] vehicles=new Vehicle[3];
        vehicles[0]=new Car(180,"Petrol",5);
        vehicles[1]=new Truck(120,"Diesel",2000);
        vehicles[2]=new Motorcycle(160,"Petrol",true);
        for(Vehicle v:vehicles){
            v.displayInfo();
            System.out.println();
        }
    }
}
