import java.util.function.Predicate;
public class TemperatureAlertApplication {
    public static void main(String[] args) {
        // Predicate to check if temperature crosses threshold
        Predicate<Double> temperatureAlert = temperature -> temperature > 40.0;
        double currentTemperature = 45.2;
        // Evaluates temperature condition
        if (temperatureAlert.test(currentTemperature)) {
            System.out.println("Alert: Temperature crossed safe limit!");
        } else {
            System.out.println("Temperature is within safe range.");
        }
    }
}
