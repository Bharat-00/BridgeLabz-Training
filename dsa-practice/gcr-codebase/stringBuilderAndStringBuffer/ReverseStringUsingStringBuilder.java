public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        // Input string
        String inputString = "hello";
        // Create StringBuilder object
        StringBuilder stringBuilder = new StringBuilder(inputString);
        // Reverse the string
        String reversedString = stringBuilder.reverse().toString();
        // Print results
        System.out.println("Original String: " + inputString);
        System.out.println("Reversed String: " + reversedString);
    }
}
