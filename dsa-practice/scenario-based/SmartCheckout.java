import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//CUSTOMER CLASS
class Customer {
    String name;
    List<String> items;
    public Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}
//CHECKOUT SYSTEM
class CheckoutSystem {
    private Queue<Customer> queue = new LinkedList<>();
    private Map<String, Integer> priceMap = new HashMap<>();
    private Map<String, Integer> stockMap = new HashMap<>();
    public CheckoutSystem() {
        priceMap.put("Milk", 50);
        priceMap.put("Bread", 40);
        priceMap.put("Rice", 60);
        stockMap.put("Milk", 10);
        stockMap.put("Bread", 5);
        stockMap.put("Rice", 8);
    }
    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.name + " added to queue");
    }
    public void processCustomer() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Customer customer = queue.poll();
        int bill = 0;
        for (String item : customer.items) {
            if (stockMap.getOrDefault(item, 0) > 0) {
                bill += priceMap.get(item);
                stockMap.put(item, stockMap.get(item) - 1);
            } else {
                System.out.println(item + " is out of stock");
            }
        }
        System.out.println("Customer: " + customer.name + " | Total Bill: ₹" + bill);
    }
}
//MAIN CLASS
public class SmartCheckout {
    public static void main(String[] args) {
        CheckoutSystem system = new CheckoutSystem();
        system.addCustomer(new Customer("Amit", Arrays.asList("Milk", "Bread")));
        system.addCustomer(new Customer("Neha", Arrays.asList("Rice", "Milk")));
        system.addCustomer(new Customer("Rahul", Arrays.asList("Milk", "Milk")));
        System.out.println("\n Processing Customers...\n");
        system.processCustomer();
        system.processCustomer();
        system.processCustomer();
    }
}
