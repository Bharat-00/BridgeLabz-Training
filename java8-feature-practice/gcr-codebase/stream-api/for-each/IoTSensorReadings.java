import java.util.Arrays;
import java.util.List;
public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Double> readings = Arrays.asList(35.5, 42.3, 28.9, 50.1, 39.7);
        double threshold = 40.0;
        readings.stream()
                .filter(reading -> reading > threshold)
                .forEach(reading ->
                        System.out.println("Alert! High Reading: " + reading));
    }
}
