import java.util.Scanner;
public class FlipKeyLogicalProblem {
    public static String cleanseAndInvert(String input) {
        // Validation 1: null or length < 6
        if (input == null || input.length() < 6) {
            return "";
        }
        // Validation 2: no spaces, digits, or special characters
        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return "";
            }
        }
        // Step 1: Convert to lowercase
        input = input.toLowerCase();
        // Step 2: Remove characters with even ASCII values
        StringBuilder filtered = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch % 2 != 0) {   // keep odd ASCII
                filtered.append(ch);
            }
        }
        // Step 3: Reverse the string
        filtered.reverse();
        // Step 4: Uppercase characters at even index
        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
            }
        }
        return filtered.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String input = sc.nextLine();
        String result = cleanseAndInvert(input);
        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is : " + result);
        }
        sc.close();
    }
}
