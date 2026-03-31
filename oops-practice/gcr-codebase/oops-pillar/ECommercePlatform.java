import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class Product {
    // Encapsulated fields
    private final int productId;
    private final String name;
    protected double price;
    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    // Abstract method
    public abstract double calculateDiscount();
    // Getters
    public int getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
/* -------------------- ELECTRONICS -------------------- */
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }
    @Override
    public double calculateTax() {
        return price * 0.18;
    }
    @Override
    public String getTaxDetails() {
        return "18% GST Applied";
    }
}
/* -------------------- CLOTHING -------------------- */
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return price * 0.20;
    }
    @Override
    public double calculateTax() {
        return price * 0.12;
    }
    @Override
    public String getTaxDetails() {
        return "12% GST Applied";
    }
}
/* -------------------- GROCERIES -------------------- */
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return price * 0.05;
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "Jacket", 3000));
        products.add(new Groceries(3, "Rice Bag", 1200));
        System.out.println("===== Product Billing Details =====");
        // Polymorphism
        for (Product product : products) {
            if (product == null) continue;
            double tax = 0;
            if (product instanceof Taxable taxable) {
                tax = taxable.calculateTax();
            }
            double discount = product.calculateDiscount();
            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Product Name : " + product.getName());
            System.out.println("Base Price  : ₹" + product.getPrice());
            System.out.println("Tax         : ₹" + tax);
            System.out.println("Discount    : ₹" + discount);
            System.out.println("Final Price : ₹" + finalPrice);
            System.out.println("----------------------------------");
        }
    }
}
