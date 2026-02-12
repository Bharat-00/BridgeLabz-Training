import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// Utility interface with static method
interface DateUtil {
    // Formats date using provided pattern
    static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
public class DateFormatApplication {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        // Uses static interface method
        System.out.println(DateUtil.format(today, "dd-MM-yyyy"));
        System.out.println(DateUtil.format(today, "yyyy/MM/dd"));
    }
}
