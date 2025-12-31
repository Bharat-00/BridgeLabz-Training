// Program to check whether a string is palindrome
// PalindromeChecker class definition
class PalindromeChecker {
    // Instance variable
    private final String text;
    // Constructor to initialize text
    public PalindromeChecker(String text) {
        this.text = text;
    }
    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        String reversedText = "";
        for (int i = cleanedText.length() - 1; i >= 0; i--) {
            reversedText += cleanedText.charAt(i);
        }
        return cleanedText.equals(reversedText);
    }
    // Method to display result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}
// Main class
public class PalindromeTest {
    public static void main(String[] args) {
        // Creating PalindromeChecker objects
        PalindromeChecker checker1 =
                new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker checker2 =
                new PalindromeChecker("Hello");
        // Displaying results
        checker1.displayResult();
        checker2.displayResult();
    }
}
