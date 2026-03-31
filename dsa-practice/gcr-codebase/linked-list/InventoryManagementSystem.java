// Singly Linked List for Inventory Management System
public class InventoryManagementSystem {
    // Node class representing an inventory item
    class ItemNode {
        int itemId;
        String itemName;
        int quantity;
        double price;
        ItemNode next;
        ItemNode(int itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }
    private ItemNode head;
    // 1. Add item at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning.");
    }
    // 2. Add item at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Item added at end.");
    }
    // 3. Remove item by Item ID
    public void removeByItemId(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }
    // 4. Update quantity by Item ID
    public void updateQuantity(int id, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }
    // 5. Search item by ID or Name
    public void searchItem(int id, String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id || temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }
    // 6. Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }
    // 7. Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        ItemNode temp = head;
        System.out.println("\n--- Inventory Items ---");
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }
    // Helper method
    private void displayItem(ItemNode item) {
        System.out.println("ID: " + item.itemId +
                ", Name: " + item.itemName +
                ", Qty: " + item.quantity +
                ", Price: ₹" + item.price);
    }
    // Main method
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        inventory.addAtBeginning(101, "Laptop", 5, 50000);
        inventory.addAtEnd(102, "Mouse", 20, 500);
        inventory.addAtEnd(103, "Keyboard", 10, 1500);
        inventory.displayInventory();
        inventory.updateQuantity(102, 25);
        inventory.searchItem(103, "");
        inventory.calculateTotalValue();
        inventory.removeByItemId(101);
        inventory.displayInventory();
    }
}
