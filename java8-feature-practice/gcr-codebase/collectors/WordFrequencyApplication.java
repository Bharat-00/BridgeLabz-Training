import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
public class WordFrequencyApplication {
    public static void main(String[] args) {
        // Input paragraph
        String paragraph = "java streams are powerful and java streams are fast";
        // Counts word frequency
        Map<String, Integer> wordCount = Arrays.stream(paragraph.split(" "))
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        Integer::sum
                ));
        wordCount.forEach((word, count) ->
                System.out.println(word + " : " + count));
    }
}
