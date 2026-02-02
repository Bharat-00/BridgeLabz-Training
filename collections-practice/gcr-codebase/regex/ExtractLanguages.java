import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(JavaScript|Java|Python|Go)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (result.length() > 0) {
                result.append(",");
            }
            result.append(matcher.group());
        }
        System.out.println(result);
    }
}
