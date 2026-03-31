public class DigitalPaymentApplication {
    public static void main(String[] args) {
        // Creating payment method objects using interface reference
        PaymentMethod upiPayment = new UpiPayment();
        PaymentMethod creditCardPayment = new CreditCardPayment();
        PaymentMethod walletPayment = new WalletPayment();
        // Processing payments
        upiPayment.pay();
        creditCardPayment.pay();
        walletPayment.pay();
    }
}
// Common interface for all digital payment methods
interface PaymentMethod {
    // Executes the payment
    void pay();
}
// UPI payment implementation
class UpiPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Payment processed using UPI");
    }
}
// Credit card payment implementation
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Payment processed using Credit Card");
    }
}
// Wallet payment implementation
class WalletPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Payment processed using Wallet");
    }
}
