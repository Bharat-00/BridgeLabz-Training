import java.util.*;
import java.util.regex.*;
public class FindRepeatingWords {
    public static void main(String[] args) {
        String input = "This is a repeated repeated word test.";
        input = input.toLowerCase();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(input);
        Map<String, Integer> countMap = new LinkedHashMap<>();
        while (matcher.find()) {
            String word = matcher.group();
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
