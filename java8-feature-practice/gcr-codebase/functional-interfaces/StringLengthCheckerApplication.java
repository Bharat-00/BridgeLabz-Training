import java.util.function.Function;
public class StringLengthCheckerApplication {
    public static void main(String[] args) {
        // Function to calculate string length
        Function<String, Integer> stringLengthFunction = String::length;
        String message = "Server maintenance scheduled tonight";
        // Applies function to get message length
        int length = stringLengthFunction.apply(message);
        System.out.println("Message length: " + length);
        if (length > 30) {
            System.out.println("Warning: Message exceeds character limit.");
        }
    }
}
