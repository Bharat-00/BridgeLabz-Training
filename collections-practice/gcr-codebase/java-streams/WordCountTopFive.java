import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class WordCountTopFive {
    public static void main(String[] args) {
        String filePath = "textfile.txt"; // change path if needed
        Map<String, Integer> wordCountMap = new HashMap<>();
        // Read file and count words
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase()
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word,
                                wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }
        // Sort words by frequency
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCountMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        // Display top 5 words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(
                    list.get(i).getKey() + " = " + list.get(i).getValue());
        }
    }
}
