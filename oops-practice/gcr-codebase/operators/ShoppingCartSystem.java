// Program to demonstrate Shopping Cart System
// Concepts used: static, this, final, instanceof
// Product class definition
class Product {
    // Static variable shared across all products
    static double discount = 10.0;   // Discount percentage
    // Private final instance variables
    private final String productID;     // Unique and immutable
    private final String productName;
    private final double price;
    private final int quantity;
    // Constructor using 'this' keyword
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    // Method to calculate price after discount
    public double calculateDiscountedPrice() {
        return price - (price * discount / 100);
    }
    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Price after Discount: $" + calculateDiscountedPrice());
        System.out.println();
    }
}
// Main class
public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Creating Product objects
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);
        // Validating objects using instanceof
        if (product1 instanceof Product) {
            product1.displayProductDetails();
        }
        if (product2 instanceof Product) {
            product2.displayProductDetails();
        }
    }
}
