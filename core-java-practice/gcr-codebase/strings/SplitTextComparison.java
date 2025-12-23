import java.util.Scanner;
public class SplitTextComparison {
    // Method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
        }
        return count;
    }
    // Method to split text into words without using split()
    public static String[] manualSplit(String text) {
        int length = findLength(text);
        int wordCount = 1;
        // Count number of words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        // Store indexes of spaces
        int[] spaceIndex = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }
        // Extract words
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            String word = "";
            for (int j = start; j < spaceIndex[i]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            start = spaceIndex[i] + 1;
        }
        // Last word
        String lastWord = "";
        for (int i = start; i < length; i++) {
            lastWord += text.charAt(i);
        }
        words[wordCount - 1] = lastWord;
        return words;
    }
    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            int len1 = findLength(arr1[i]);
            int len2 = findLength(arr2[i]);
            if (len1 != len2) {
                return false;
            }
            for (int j = 0; j < len1; j++) {
                if (arr1[i].charAt(j) != arr2[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take user input
        System.out.print("Enter the text: ");
        String input = sc.nextLine();
        // User-defined split
        String[] manualWords = manualSplit(input);
        // Built-in split
        String[] builtInWords = input.split(" ");
        // Compare results
        boolean result = compareArrays(manualWords, builtInWords);
        // Display words
        System.out.println("Manual Split Result:");
        for (String word : manualWords) {
            System.out.println(word);
        }
        System.out.println("Built-in Split Result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }
        System.out.println("Are both results equal? " + result);
    }
}
