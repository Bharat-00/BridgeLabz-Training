import java.util.ArrayList;
import java.util.List;
// Abstract base class
abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String getCategory();
}
// Subclasses
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
    @Override
    public String getCategory() {
        return "Electronics";
    }
}
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
    @Override
    public String getCategory() {
        return "Groceries";
    }
}
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
    @Override
    public String getCategory() {
        return "Furniture";
    }
}
// Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
    // Wildcard method
    public static void displayAllItems(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            System.out.println(item.getCategory() + " : " + item.getName());
        }
    }
}
// Main class
public class SmartWarehouseApp {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));
        System.out.println("=== Electronics ===");
        Storage.displayAllItems(electronicsStorage.getItems());
        System.out.println("\n=== Groceries ===");
        Storage.displayAllItems(groceryStorage.getItems());
    }
}
