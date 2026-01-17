import java.util.HashSet;
public class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        // Input string
        String inputString = "programming";
        // StringBuilder to store result
        StringBuilder result = new StringBuilder();
        // HashSet to track already seen characters
        HashSet<Character> characterSet = new HashSet<>();
        // Iterate through the string
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            // Add character only if not already present
            if (!characterSet.contains(currentChar)) {
                characterSet.add(currentChar);
                result.append(currentChar);
            }
        }
        // Print results
        System.out.println("Original String: " + inputString);
        System.out.println("String After Removing Duplicates: " + result.toString());
    }
}
