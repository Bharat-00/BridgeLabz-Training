import java.util.Scanner;
public class CharacterFrequency2 {
    // Method to find unique characters in a string
    public static char[] uniqueCharacters(String str) {
        String unique = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (unique.indexOf(ch) == -1) { // If character not already in unique
                unique += ch;
            }
        }
        return unique.toCharArray();
    }
    // Method to find frequency of characters and return 2D array
    public static String[][] characterFrequency(String str) {
        int[] freq = new int[256]; // Array to store frequency of all ASCII characters
        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        char[] uniqueChars = uniqueCharacters(str);
        String[][] result = new String[uniqueChars.length][2];
        // Store unique characters and their frequencies in 2D array
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] freqArray = characterFrequency(input);
        System.out.println("Character Frequencies:");
        System.out.println("Character : Frequency");
        for (int i = 0; i < freqArray.length; i++) {
            System.out.println(freqArray[i][0] + " : " + freqArray[i][1]);
        }
    }
}
