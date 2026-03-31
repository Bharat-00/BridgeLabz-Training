public class UnitConversionApplication {
    public static void main(String[] args) {
        double distanceKm = 10.0;
        double weightKg = 5.0;
        // Converts units using static interface methods
        System.out.println("Distance in miles: " + UnitConverter.kmToMiles(distanceKm));
        System.out.println("Weight in lbs: " + UnitConverter.kgToLbs(weightKg));
    }
}
// Utility interface for unit conversions
interface UnitConverter {
    // Converts kilometers to miles
    static double kmToMiles(double kilometers) {
        return kilometers * 0.621371;
    }
    // Converts kilograms to pounds
    static double kgToLbs(double kilograms) {
        return kilograms * 2.20462;
    }
}
