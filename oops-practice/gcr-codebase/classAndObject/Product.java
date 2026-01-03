public class Product {
    // Instance Variables (Unique to each product)
    private final String productName;
    private final double price;
    // Class Variable (Shared among all products)
    private static int totalProducts = 0;
    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        // Increment the shared counter whenever a new object is created
        totalProducts++;
    }
    // Instance Method: Displays details specific to this object
    public void displayProductDetails() {
        System.out.println("Product: " + productName + " | Price: $" + price);
    }
    // Class Method: Displays the shared total count
    // 'static' methods can be called without creating an object
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
    // Main method to test
    public static void main(String[] args) {
        System.out.println("--- Problem 1: Product Inventory ---");
        // 1. Create first product
        Product p1 = new Product("Laptop", 999.99);
        p1.displayProductDetails();
        // 2. Create second product
        Product p2 = new Product("Smartphone", 499.99);
        p2.displayProductDetails();
        // 3. Create third product
        Product p3 = new Product("Headphones", 199.99);
        p3.displayProductDetails();
        System.out.println();
        // 4. Check total products (Accessed via the class name)
        Product.displayTotalProducts(); 
    }
}