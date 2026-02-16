import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
class Claim {
    String type;
    double amount;
    public Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    public String getType() { return type; }
    public double getAmount() { return amount; }
}
public class InsuranceAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("Health", 5000),
                new Claim("Health", 7000),
                new Claim("Car", 15000),
                new Claim("Car", 20000),
                new Claim("Home", 30000)
        );
        Map<String, Double> averageClaims =
                claims.stream()
                        .collect(groupingBy(
                                Claim::getType,
                                averagingDouble(Claim::getAmount)
                        ));
        averageClaims.forEach((type, avg) ->
                System.out.println(type + " Average: " + avg));
    }
}
