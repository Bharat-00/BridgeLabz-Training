import java.util.Arrays;
import java.util.List;
public class EmailNotifications {
    public static void sendEmailNotification(String email) {
        System.out.println("Email sent to: " + email);
    }
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "bharat@gmail.com",
                "aman@gmail.com",
                "riya@gmail.com"
        );
        emails.forEach(email -> sendEmailNotification(email));
    }
}
