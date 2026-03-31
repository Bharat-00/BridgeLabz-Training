import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountWordInFile {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // replace with your file name
        String targetWord = "java";     // word to count
        int count = 0;
        try {
            // Create FileReader and BufferedReader
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Split line into words
                String[] words = line.split("\\s+");
                // Check each word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            // Close resources
            bufferedReader.close();
            fileReader.close();
            // Print result
            System.out.println("The word '" + targetWord + "' appears " + count + " times.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
