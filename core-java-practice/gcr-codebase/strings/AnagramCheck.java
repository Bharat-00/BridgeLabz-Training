import java.util.Scanner;
public class AnagramCheck {
    // Method to check if two texts are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase for accurate comparison
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();
        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] freq1 = new int[256]; // Frequency array for str1
        int[] freq2 = new int[256]; // Frequency array for str2
        // Count frequency of each character in str1
        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
        }
        // Count frequency of each character in str2
        for (int i = 0; i < str2.length(); i++) {
            freq2[str2.charAt(i)]++;
        }
        // Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();
        boolean result = areAnagrams(text1, text2);
        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }
    }
}
