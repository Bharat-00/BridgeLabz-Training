import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class InvoiceCreationApplication {
    public static void main(String[] args) {
        // List of transaction IDs received from payment system
        List<String> transactionIds = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003",
                "TXN1004"
        );
        // Creates invoice objects using constructor reference
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());
        // Prints generated invoices for verification
        invoices.forEach(System.out::println);
    }
}
class Invoice {
    private String transactionId;
    // Constructor used by constructor reference
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }
    // Returns invoice details in readable format
    @Override
    public String toString() {
        return "Invoice{transactionId='" + transactionId + "'}";
    }
}
