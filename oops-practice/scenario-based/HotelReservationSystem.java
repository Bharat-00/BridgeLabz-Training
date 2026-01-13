class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String msg) {
        super(msg);
    }
}
interface PricingStrategy {
    double calculatePrice(int days);
}
class SeasonalPricing implements PricingStrategy {
    @Override
    public double calculatePrice(int days) {
        return days * 3000;
    }
}
public class HotelReservationSystem {
    public static void main(String[] args) {
        PricingStrategy price = new SeasonalPricing();
        System.out.println("Bill: ₹" + price.calculatePrice(2));
    }
}
