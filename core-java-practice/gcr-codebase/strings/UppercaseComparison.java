import java.util.Scanner;
public class UppercaseComparison {
    // Method to convert a string to uppercase using charAt() and ASCII logic
    public static String convertToUppercase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Check if character is lowercase
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // Convert to uppercase using ASCII difference
            }
            result += ch; // Append to result string
        }
        return result;
    }
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false; // If lengths differ, strings are not equal
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false; // If any character differs, strings are not equal
            }
        }
        return true; // Strings are equal
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take complete text input
        System.out.print("Enter the complete text: ");
        String input = sc.nextLine();
        // Convert to uppercase using user-defined method
        String manualUppercase = convertToUppercase(input);
        // Convert to uppercase using built-in method
        String builtinUppercase = input.toUpperCase();
        // Display both uppercase results
        System.out.println("Manual Uppercase: " + manualUppercase);
        System.out.println("Built-in Uppercase: " + builtinUppercase);
        // Compare using user-defined method
        boolean isEqual = compareStrings(manualUppercase, builtinUppercase);
        System.out.println("Are both uppercase results equal? " + isEqual);
    }
}
