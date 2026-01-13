class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) {
        super(msg);
    }
}
interface FareCalculator {
    double calculateFare(int km);
}
class NormalFare implements FareCalculator {
    @Override
    public double calculateFare(int km) {
        return km * 10;
    }
}
class PeakFare implements FareCalculator {
    @Override
    public double calculateFare(int km) {
        return km * 15;
    }
}
public class CabbookingSystem2 {
    public static void main(String[] args) {
        FareCalculator fare = new PeakFare();
        System.out.println("Fare: ₹" + fare.calculateFare(10));
    }
}
