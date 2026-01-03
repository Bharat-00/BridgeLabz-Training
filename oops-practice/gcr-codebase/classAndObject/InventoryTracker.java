// Program to track inventory of items
// Item class definition
class Item {
    // Instance variables
    private final String itemCode;
    private final String itemName;
    private final double itemPrice;
    // Constructor to initialize item details
    public Item(String itemCode, String itemName, double itemPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    // Method to display item details
    public void displayDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + itemPrice);
        System.out.println("itemName : " + itemName);
        System.out.println();
    }
}
// Main class
public class InventoryTracker {
    public static void main(String[] args) {
        // Creating Item objects
        Item item1 = new Item("01AA", "Water bottle", 500.0);
        Item item2 = new Item("01BB", "Rice", 700.0);
        Item item3 = new Item("02AA", "blackboard", 400.0);
        // Displaying item details
        item1.displayDetails();
        item2.displayDetails();
        item3.displayDetails();
    }
}
