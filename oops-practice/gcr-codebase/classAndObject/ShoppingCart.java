// Program to simulate a shopping cart
// CartItem class definition
class CartItem {
    // Instance variables
    private final String itemName;
    private final double price;
    private int quantity;
    // Constructor to initialize cart item
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    // Method to add items to the cart
    public void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }
    // Method to remove items from the cart
    public void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }
    // Method to calculate total cost
    public double calculateTotalCost() {
        return price * quantity;
    }
    // Method to display total cost
    public void displayTotalCost() {
        System.out.printf("Total cost: $%.2f%n", calculateTotalCost());
    }
    // Method to display item details
    public void displayItemDetails() {
        System.out.printf("Item: %s, Price: $%.2f, Quantity: %d%n",
                itemName, price, quantity);
    }
}
// Main class
public class ShoppingCart {
    public static void main(String[] args) {
        // Creating CartItem object
        CartItem item = new CartItem("Laptop", 999.99, 1);
        // Display initial item details
        item.displayItemDetails();
        // Adding items to the cart
        item.addItem(2);
        // Removing items from the cart
        item.removeItem(1);
        // Displaying total cost
        item.displayTotalCost();
    }
}
