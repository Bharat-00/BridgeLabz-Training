import java.util.Scanner;
public class NumberFormatExceptionDemo {
    // Method to generate NumberFormatException
    public static void generateException(String str) {
        System.out.println("Generating NumberFormatException...");
        // Attempt to convert non-numeric string to integer
        int num = Integer.parseInt(str); // This will throw NumberFormatException if input is not numeric
        System.out.println("Converted number: " + num);
    }
    // Method to handle NumberFormatException
    public static void handleException(String str) {
        try {
            System.out.println("Trying to convert string to number...");
            int num = Integer.parseInt(str); // Potential exception
            System.out.println("Converted number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("Other runtime exception caught: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        // Call method to generate exception safely
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e);
        }
        // Call method to handle exception
        handleException(input);
    }
}
