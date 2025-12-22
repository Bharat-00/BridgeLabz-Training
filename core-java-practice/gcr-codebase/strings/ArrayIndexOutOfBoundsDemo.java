import java.util.Scanner;
public class ArrayIndexOutOfBoundsDemo {
    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] arr) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        // Accessing an index beyond the array length
        System.out.println("Accessing element at index 10: " + arr[10]); // Will throw exception
    }
    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] arr) {
        try {
            System.out.println("Trying to access an invalid index...");
            System.out.println("Element at index 10: " + arr[10]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e);
            System.out.println("Please access a valid index between 0 and " + (arr.length - 1));
        } catch (RuntimeException e) {
            System.out.println("Other runtime exception caught: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input for array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        // Call method to generate exception safely
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        }
        // Call method to handle exception
        handleException(names);
    }
}
