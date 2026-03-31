import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class OrderRevenueApplication {
    public static void main(String[] args) {
        // Order list
        List<Order> orders = Arrays.asList(
                new Order("Bharat", 1200.50),
                new Order("Ananya", 800.00),
                new Order("Bharat", 450.75)
        );
        // Sums order totals per customer
        Map<String, Double> revenueByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getAmount)
                ));
        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " Total: " + total));
    }
}
class Order {
    private String customerName;
    private double amount;
    public Order(String customerName, double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getAmount() {
        return amount;
    }
}
