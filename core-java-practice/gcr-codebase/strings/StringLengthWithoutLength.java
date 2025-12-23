import java.util.Scanner;
public class StringLengthWithoutLength {
    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            // Exception occurs when index goes out of bounds
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.next();
        // Call user-defined method
        int manualLength = findLength(input);
        // Call built-in length() method
        int builtinLength = input.length();
        // Display results
        System.out.println("Length without using length(): " + manualLength);
        System.out.println("Length using built-in length(): " + builtinLength);
    }
}
