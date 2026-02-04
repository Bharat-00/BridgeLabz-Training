import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
class Alert {
    String message;
    String type;   // Emergency, Appointment, General
    Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }
    public String toString() {
        return type + " Alert: " + message;
    }
}
public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("Heart rate critical", "Emergency"));
        alerts.add(new Alert("Doctor appointment at 5 PM", "Appointment"));
        alerts.add(new Alert("Health tips available", "General"));
        // User preference: show only Emergency alerts
        Predicate<Alert> emergencyOnly =
                alert -> alert.type.equalsIgnoreCase("Emergency");
        System.out.println("Filtered Alerts:");
        alerts.stream()
              .filter(emergencyOnly)
              .forEach(System.out::println);
    }
}
