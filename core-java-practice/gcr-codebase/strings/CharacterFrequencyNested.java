import java.util.Scanner;
public class CharacterFrequencyNested {
    // Method to find frequency of characters using nested loops
    public static String[] characterFrequency(String str) {
        char[] chars = str.toCharArray(); // Convert string to char array
        int n = chars.length;
        int[] freq = new int[n]; // Array to store frequency of each character
        // Initialize frequency array
        for (int i = 0; i < n; i++) {
            freq[i] = 1; // Each character appears at least once
        }
        // Nested loop to count frequency
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') continue; // Skip already counted duplicates
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate as counted
                }
            }
        }
        // Count how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') uniqueCount++;
        }
        // Create result array to store characters and their frequencies
        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[] frequencies = characterFrequency(input);
        System.out.println("Character Frequencies:");
        for (String s : frequencies) {
            System.out.println(s);
        }
    }
}
