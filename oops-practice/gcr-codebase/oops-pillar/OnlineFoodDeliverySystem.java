import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class FoodItem {
    // Encapsulated fields
    private final String itemName;
    protected double price;
    protected int quantity;
    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    // Abstract method
    public abstract double calculateTotalPrice();
    // Concrete method
    public void getItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
        System.out.println("Quantity  : " + quantity);
    }
}
/* -------------------- VEG ITEM -------------------- */
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }
    @Override
    public String getDiscountDetails() {
        return "10% discount on Veg Items";
    }
}
/* -------------------- NON-VEG ITEM -------------------- */
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice() {
        double extraCharge = 50;
        return (price * quantity) + extraCharge;
    }
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }
    @Override
    public String getDiscountDetails() {
        return "5% discount on Non-Veg Items";
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));
        System.out.println("===== Order Summary =====");
        double grandTotal = 0;
        // Polymorphism
        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            double discount = 0;
            if (item instanceof Discountable discountable) {
                discount = discountable.applyDiscount();
                System.out.println(discountable.getDiscountDetails());
            }
            double finalAmount = total - discount;
            grandTotal += finalAmount;
            System.out.println("Total Price : ₹" + total);
            System.out.println("Discount   : ₹" + discount);
            System.out.println("Final Amt  : ₹" + finalAmount);
            System.out.println("--------------------------------");
        }
        System.out.println("Grand Total Payable: ₹" + grandTotal);
    }
}
