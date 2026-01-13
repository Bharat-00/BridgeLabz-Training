class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) {
        super(msg);
    }
}
interface Payment {
    void pay(double amount) throws PaymentFailedException;
}
class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
    }
}
class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
class Order {
    Product product;
    Order(Product product) {
        this.product = product;
    }
    void placeOrder(Payment payment) throws PaymentFailedException {
        payment.pay(product.price);
        System.out.println("Order placed for " + product.name);
    }
}
public class EcommerceSystem {
    public static void main(String[] args) throws Exception {
        Product p = new Product("Laptop", 60000);
        Order order = new Order(p);
        order.placeOrder(new CardPayment());
    }
}
