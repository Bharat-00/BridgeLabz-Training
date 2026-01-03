// Program to handle mobile phone details
// MobilePhone class definition
class MobilePhone {
    // Instance variables
    private final String brand;
    private final String model;
    private final double price;
    // Constructor to initialize mobile phone details
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    // Method to display mobile phone details
    public void displayDetails() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println();
    }
}
// Main class
public class MobilePhoneDetails {
    public static void main(String[] args) {
        // Creating MobilePhone objects
        MobilePhone mobile1 = new MobilePhone("VIVO", "V29", 15999.0);
        MobilePhone mobile2 = new MobilePhone("ONE PLUS", "ONE PLUS nord4", 39999.0);
        MobilePhone mobile3 = new MobilePhone("APPLE", "iphone pro16", 79999.0);
        // Displaying mobile phone details
        mobile1.displayDetails();
        mobile2.displayDetails();
        mobile3.displayDetails();
    }
}
