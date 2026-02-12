import java.io.Serializable;
// Serializable marker interface
class CustomerData implements Serializable {
    private String name;
    private String email;
    public CustomerData(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
public class BackupApplication {
    public static void main(String[] args) {
        CustomerData customer = new CustomerData("Bharat", "bharat@email.com");
        // Checks marker interface
        if (customer instanceof Serializable) {
            System.out.println("Object eligible for backup serialization");
        }
    }
}
