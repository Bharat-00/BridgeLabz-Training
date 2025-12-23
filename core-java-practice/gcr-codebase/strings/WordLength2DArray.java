import java.util.Scanner;
public class WordLength2DArray {
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
    public static String[] splitText(String text) {
        int length = findLength(text);
        int wordCount = 1;
        // Count words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        // Store space indexes
        int[] spaces = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaces[index++] = i;
            }
        }
        // Extract words
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            String word = "";
            for (int j = start; j < spaces[i]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            start = spaces[i] + 1;
        }
        // Last word
        String lastWord = "";
        for (int i = start; i < length; i++) {
            lastWord += text.charAt(i);
        }
        words[wordCount - 1] = lastWord;
        return words;
    }
    // Method to return 2D array of word and its length
    public static String[][] wordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input
        System.out.print("Enter the text: ");
        String input = sc.nextLine();
        // Split text
        String[] words = splitText(input);
        // Create 2D array
        String[][] table = wordLengthTable(words);
        // Display in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("--------------");
        for (int i = 0; i < table.length; i++) {
            String word = table[i][0];
            int length = Integer.parseInt(table[i][1]);
            System.out.println(word + "\t" + length);
        }
    }
}
