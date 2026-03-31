// Payment processor interface with default refund
interface PaymentProcessor {
    void processPayment(double amount);
    // Newly added default refund method
    default void refund(double amount) {
        System.out.println("Refund processed: " + amount);
    }
}
class RazorpayProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Payment processed via Razorpay: " + amount);
    }
}
public class PaymentGatewayApplication {
    public static void main(String[] args) {
        PaymentProcessor processor = new RazorpayProcessor();
        processor.processPayment(1500);
        processor.refund(500);
    }
}
