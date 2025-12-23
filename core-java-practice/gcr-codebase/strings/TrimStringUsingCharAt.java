import java.util.Scanner;
public class TrimStringUsingCharAt {
    // Method to find start and end index without spaces
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;
        // Trim leading spaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        // Trim trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }
    // Method to create substring using charAt()
    public static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter the string with spaces: ");
        String input = sc.nextLine();
        // User-defined trimming
        int[] indexes = findTrimIndexes(input);
        String manualTrim = "";
        if (indexes[0] <= indexes[1]) {
            manualTrim = createSubstring(input, indexes[0], indexes[1]);
        }
        // Built-in trim
        String builtinTrim = input.trim();
        // Compare results
        boolean result = compareStrings(manualTrim, builtinTrim);
        // Display results
        System.out.println("Manual Trim Result: [" + manualTrim + "]");
        System.out.println("Built-in Trim Result: [" + builtinTrim + "]");
        System.out.println("Are both results equal? " + result);
    }
}
