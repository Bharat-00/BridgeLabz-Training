import java.util.Arrays;
import java.util.List;
public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(245.50, 247.30, 249.10, 246.80);
        stockPrices.forEach(price ->
                System.out.println("Live Stock Price: ₹" + price));
    }
}
