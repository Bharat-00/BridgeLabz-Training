public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        // Array of strings
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java"};
        // Create StringBuffer object
        StringBuffer stringBuffer = new StringBuffer();
        // Append each string from the array
        for (String word : words) {
            stringBuffer.append(word);
        }
        // Convert to String
        String result = stringBuffer.toString();
        // Print result
        System.out.println("Concatenated String:");
        System.out.println(result);
    }
}
