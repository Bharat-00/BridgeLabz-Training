import java.util.Scanner;
public class LowercaseComparison {
    // Method to convert a string to lowercase using charAt() and ASCII logic
    public static String convertToLowercase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Check if character is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // Convert to lowercase using ASCII difference
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
        // Convert to lowercase using user-defined method
        String manualLowercase = convertToLowercase(input);
        // Convert to lowercase using built-in method
        String builtinLowercase = input.toLowerCase();
        // Display both lowercase results
        System.out.println("Manual Lowercase: " + manualLowercase);
        System.out.println("Built-in Lowercase: " + builtinLowercase);
        // Compare using user-defined method
        boolean isEqual = compareStrings(manualLowercase, builtinLowercase);
        System.out.println("Are both lowercase results equal? " + isEqual);
    }
}
