import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "https?://[\\w.-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted links:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
