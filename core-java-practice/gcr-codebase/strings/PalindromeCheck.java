import java.util.Scanner;
public class PalindromeCheck {
    // Logic 1: Iterative method
    public static boolean isPalindromeIterative(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true; // Base case: crossed indices
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
    // Logic 3: Using char arrays and reverse comparison
    public static boolean isPalindromeCharArray(String str) {
        char[] original = str.toCharArray();
        char[] reversed = new char[str.length()];
        // Reverse the string using charAt()
        for (int i = 0; i < str.length(); i++) {
            reversed[i] = str.charAt(str.length() - 1 - i);
        }
        // Compare original and reversed arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = sc.nextLine();
        // Using Logic 1
        boolean resultIterative = isPalindromeIterative(input);
        System.out.println("Palindrome check (Iterative): " + (resultIterative ? "Yes" : "No"));
        // Using Logic 2
        boolean resultRecursive = isPalindromeRecursive(input, 0, input.length() - 1);
        System.out.println("Palindrome check (Recursive): " + (resultRecursive ? "Yes" : "No"));
        // Using Logic 3
        boolean resultCharArray = isPalindromeCharArray(input);
        System.out.println("Palindrome check (Char Array): " + (resultCharArray ? "Yes" : "No"));
    }
}
