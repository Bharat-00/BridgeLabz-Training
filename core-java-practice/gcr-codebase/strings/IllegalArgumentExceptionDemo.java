import java.util.Scanner;
public class IllegalArgumentExceptionDemo {
    // Method to generate IllegalArgumentException
    public static void generateException(String str) {
        System.out.println("Generating IllegalArgumentException...");
        // Start index is greater than end index to generate exception
        String sub = str.substring(5, 2); // This will throw IllegalArgumentException
        System.out.println("Substring: " + sub);
    }
    // Method to handle IllegalArgumentException
    public static void handleException(String str) {
        try {
            System.out.println("Trying to get substring with invalid indices...");
            String sub = str.substring(5, 2); // Invalid indices
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("Other runtime exception caught: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        // Call method to generate exception
        generateException(input);
        // Call method to handle exception
        handleException(input);
    }
}
