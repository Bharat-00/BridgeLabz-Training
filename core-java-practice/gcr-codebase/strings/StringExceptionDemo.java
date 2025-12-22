import java.util.Scanner;
public class StringExceptionDemo {
    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String str) {
        System.out.println("Accessing character beyond string length...");
        // Accessing index beyond the string length to generate exception
        char ch = str.charAt(str.length()); // This will throw StringIndexOutOfBoundsException
        System.out.println("Character at index: " + ch);
    }
    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String str) {
        try {
            System.out.println("Trying to access character beyond string length...");
            char ch = str.charAt(str.length()); // Potential exception
            System.out.println("Character at index: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
            System.out.println("Please access a valid index between 0 and " + (str.length() - 1));
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
        sc.close();
    }
}
