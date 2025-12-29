import java.util.Scanner;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String firstString = scanner.nextLine();
        System.out.print("Enter second string: ");
        String secondString = scanner.nextLine();
        if (firstString.length() != secondString.length()) {
            System.out.println("The strings are NOT Anagrams.");
            return;
        }
        int[] frequency = new int[256];
        // Update frequency count
        for (int index = 0; index < firstString.length(); index++) {
            frequency[firstString.charAt(index)]++;
            frequency[secondString.charAt(index)]--;
        }
        // Check if all frequencies are zero
        for (int value : frequency) {
            if (value != 0) {
                System.out.println("The strings are NOT Anagrams.");
                return;
            }
        }
        System.out.println("The strings are Anagrams.");
    }
}
