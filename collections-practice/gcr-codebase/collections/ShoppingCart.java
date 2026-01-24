import java.util.*;
class ShoppingCart {
    // Stores product prices
    private HashMap<String, Integer> productPrices = new HashMap<>();
    // Maintains insertion order
    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
    // Add product
    public void addProduct(String product, int price) {
        productPrices.put(product, price);
        cartItems.put(product, price);
    }
    // Display items in insertion order
    public void displayCart() {
        System.out.println("Cart Items (Insertion Order): " + cartItems);
    }
    // Display items sorted by price
    public void displaySortedByPrice() {
        TreeMap<Integer, String> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : productPrices.entrySet()) {
            sortedByPrice.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Items Sorted By Price: " + sortedByPrice);
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 60000);
        cart.addProduct("Mouse", 800);
        cart.addProduct("Keyboard", 1500);
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
